package com.github.chen0040.benchmarks;


import java.io.InputStream;


/**
 * Created by xschen on 14/6/2017.
 */
public class ResourceFileUtils {
   public static InputStream getResource(String filename) {
      return ResourceFileUtils.class.getClassLoader().getResourceAsStream(filename);
   }
}
