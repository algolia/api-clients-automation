package com.algolia.codegen;

import org.openapitools.codegen.utils.CamelizeOption;
import org.openapitools.codegen.utils.StringUtils;

class Scratch {
    public static void main(String[] args) {
        String s;
        s = StringUtils.camelize("name-example", CamelizeOption.LOWERCASE_FIRST_CHAR);
        System.out.println(s);

        StringUtils.camelize("NAMEEXAMPLE", CamelizeOption.LOWERCASE_FIRST_CHAR);
        System.out.println(s);

        StringUtils.camelize("name_example", CamelizeOption.LOWERCASE_FIRST_CHAR);
        System.out.println(s);
    }
}