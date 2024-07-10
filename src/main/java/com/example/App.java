package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        //todo реализовать перебор файлов в директории : учесть, что просто ссылка не работает
        //todo реализовать проставление значений в файл csv (вроде rdy)
        //todo соединить строки в нужные (rdy)
        //todo учесть, что сверху может быть атер (вроде rdy)
//        File directory = new File("D:\\Projects_dop");
//        Arrays.stream(directory.listFiles()).forEach(f -> System.out.println(f.getAbsolutePath()));


//        for(File arr: directory.listFiles()){
//            System.out.println(arr.getAbsolutePath());
//        }

//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        Map<String, Object> jsonMap = mapper.readValue(new File("D:\\Projects_dop\\правило_абонентская_плата.yml"), Map.class);
//        String pretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
//        System.out.println(pretty);


//        mapper.findAndRegisterModules();
//        Story story = mapper.readValue(new File("D:\\Projects_dop\\правило_абонентская_плата.yml"), Story.class);
//
//        String pretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(story);
//        System.out.println(pretty);

//        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//        Response response = objectMapper.readValue(new File("D:\\Projects_dop\\правило_абонентская_плата.yml"), Response.class);
//        String intent = "";
//        for (RulesItem s : response.getRules()) {
//            intent = "";
//            for (StepsItem r : s.getSteps()) {
//                if (r.getAction() == null) {
//                    intent = r.getIntent();
//                } else if (!intent.isEmpty() && r.getAction().matches("utter_.+"))
//                    System.out.println(intent + "_" + r.getAction());
//            }
//        }

//        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//        Map<String, List<Map<String, List<Map<String, String>>>>> jsonMap = objectMapper.readValue(new File("D:\\Projects_dop\\правило_абонентская_плата.yml"), Map.class);
//        Set<String> persons = new HashSet<>();
//        AtomicReference<String> intent = new AtomicReference<>("");
//        AtomicReference<String> intentAndUtter = new AtomicReference<>("");
//
//        jsonMap.entrySet()
//                .stream()
//                .filter(x->!x.getKey().contains("version"))
//                .flatMap(x->x.getValue().stream())
//                .flatMap(x->x.entrySet().stream())
//                .filter(x->!x.getKey().contains("rule"))
//                .flatMap(x->x.getValue().stream())
//                .flatMap(x->x.entrySet().stream())
//                .filter(x->x.getKey().contains("intent") || x.getValue().matches("utter_.+"))
//                .forEach(x-> {
//                    if (x.getKey().contains("intent")){
//                        intent.set(x.getValue());
//                    } else {
//                        intentAndUtter.set(intent + x.getValue());
//                    }
//
//                    System.out.println(intentAndUtter.get());
//                });
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Response response = mapper.readValue(new URL("https://raw.githubusercontent.com/TarielZaycev/DictionaryIntents/main/%D0%9C%D0%B5%D0%B3%D0%B0%D1%81%D0%B8%D0%BB%D1%8B.yml"), Response.class);
        Set<String> intentAdnUtter = new TreeSet<>();
        List<String> intentsOr = new ArrayList<>();
        String intent;

        for (RulesItem s : response.getRules()) {
            intentsOr.clear();
            intent = "";
            for (StepsItem r : s.getSteps()) {

                //todo условие на null
                if (r.getOr() != null) {
                    for (OrItem o : r.getOr()) {
//                        System.out.println(o.getIntent());
                        intentsOr.add(o.getIntent());
                    }
                    continue;
                }

                //todo условие на пропуск лишних шагов
                if ((r.getAction() != null && !r.getAction().matches("utter_.+")) || r.getSlotWasSet() != null) {
                    continue;
                }

                if (r.getIntent() != null && (r.getOr() == null || r.getOr().isEmpty())) {
//                    System.out.println(r.getIntent());
                    intent = r.getIntent();
                } else if (!intentsOr.isEmpty()) {
//                    System.out.println(r.getAction());
                    for (String string : intentsOr) {
                        intentAdnUtter.add(string + "___" + r.getAction());
                    }
                } else if (!intent.isEmpty()){
                    intentAdnUtter.add(intent + "___" + r.getAction());
                }
            }
        }

//        for (String or : intentAdnUtter) {
//            System.out.println(or);
//        }
        Files.write(Path.of("D:\\Projects_dop\\test.csv"), intentAdnUtter);
    }
}