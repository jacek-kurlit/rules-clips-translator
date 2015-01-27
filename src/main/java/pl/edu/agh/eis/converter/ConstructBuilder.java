package pl.edu.agh.eis.converter;

import pl.edu.agh.eis.model.Construct;
import pl.edu.agh.eis.parser.Node;

import java.util.HashMap;
import java.util.Map;

public class ConstructBuilder {
    private static Map<String, Converter> converters = mapConverters();

    private static Map<String, Converter> mapConverters() {
        Map<String, Converter> converterMap = new HashMap<>();

        converterMap.put(Const.DEFTEMPLATE, new DeftemplateConverter());
        converterMap.put(Const.DEFFACTS, new DeffactsConverter());
        converterMap.put(Const.DEFGLOBAL, new DefglobalConverter());
        converterMap.put(Const.DEFMODULE, new DefmoduleConverter());

        return converterMap;
    }

    public static Construct convertToConstruct(Node parentNode) {
        final String constructName = parentNode.getKey();
        Converter converter = converters.get(constructName);

        if(converter == null) {
            return null;
        }

        return converter.convertParentNode(parentNode);
    }


}
