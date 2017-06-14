package com.github.chen0040.benchmarks;


import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.testng.Assert.*;


/**
 * Created by xschen on 14/6/2017.
 */
public class TspBenchmarkUnitTest {

   @Test
   public void test_load() {
      Tsp.Instance[] instances = Tsp.Instance.values();
      for(Tsp.Instance instance : instances){
         TspBenchmark benchmark = Tsp.get(instance);
         assertFalse(containsDuplicate(benchmark.optTour()));
         for(int i=0; i < benchmark.optTour().size(); ++i) {
            int v = benchmark.optTour().get(i);
            assertThat(benchmark.position(v)).isNotNull();
         }
         assertThat(benchmark.size()).isEqualTo(benchmark.optTour().size());
         assertThat(benchmark.optCost()).isGreaterThan(0);
         for(int i=0; i < benchmark.size(); ++i){
            for(int j=i; j < benchmark.size(); ++j) {
               if(i == j){
                  assertThat(benchmark.distance(i, j)).isEqualTo(0);
               } else {
                  assertThat(benchmark.distance(i, j)).isGreaterThanOrEqualTo(0.0);
                  assertThat(benchmark.distance(i, j)).isEqualTo(benchmark.distance(j, i));
               }
            }
         }
      }
   }

   private boolean containsDuplicate(List<Integer> list) {
      Set<Integer> set = new HashSet<>();
      for(int i=0; i < list.size(); ++i) {
         if(set.contains(list.get(i))) {
            return true;
         }
         set.add(list.get(i));
      }
      return false;
   }
}
