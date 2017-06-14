package com.github.chen0040.benchmarks;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 14/6/2017.
 */
public class Tsp {
   public enum Instance {
      a280,
      att48,
      bayg29,
      berlin52
   }

   private static Map<Instance, TspBenchmark> cache = new HashMap<>();

   public static TspBenchmark get(Instance instance) {
      TspBenchmark benchmark;
      if(cache.containsKey(instance)){
         benchmark = cache.get(instance);
      } else {
         String filename = "tsp/" + instance.name() + ".tsp.3c.csv";
         String tour_filename = "tsp/" + instance.name() + ".opt.tour.csv";
         benchmark = new TspBenchmark(filename, tour_filename);
         cache.put(instance, benchmark);
      }
      return benchmark;

   }
}
