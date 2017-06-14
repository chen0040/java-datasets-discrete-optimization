package com.github.chen0040.benchmarks;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xschen on 14/6/2017.
 */
public class TspBenchmark {
   private static final Logger logger = LoggerFactory.getLogger(TspBenchmark.class);
   private final Map<Integer, Vector2D> points = new HashMap<>();
   private final double[][] distances;
   private final int N;
   private final List<Integer> optTour = new ArrayList<>();
   private final double bestCost;

   public TspBenchmark(String topologyFilename, String optTourFilename) {

      InputStream inputStream = ResourceFileUtils.getResource(topologyFilename);
      try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
         reader.lines().forEach(line -> {
            String[] comps = line.split(",");
            int v = Integer.parseInt(comps[0]) - 1;
            double x = Double.parseDouble(comps[1]);
            double y = Double.parseDouble(comps[2]);
            Vector2D pos = new Vector2D(x, y);
            points.put(v, pos);
         });
      } catch(IOException exception) {
         logger.error("Failed to read the file " +topologyFilename, exception);
      }

      N = points.size();

      distances = new double[N][];
      for(int i=0; i < N; ++i) {
         distances[i] = new double[N];
      }

      for(int i=0; i < N; ++i) {
         for(int j = i+1; j < N; ++j) {
            double distance = points.get(i).distance(points.get(j));
            distances[i][j] = distance;
            distances[j][i] = distance;
         }
      }

      inputStream = ResourceFileUtils.getResource(optTourFilename);
      try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
         reader.lines().forEach(line -> {
            int v = Integer.parseInt(line) - 1;
            optTour.add(v);
         });
      } catch(IOException exception) {
         logger.error("Failed to read the file " +topologyFilename, exception);
      }

      double cost = 0;
      for(int i = 0; i < optTour.size(); ++i){
         int j = (i + 1) % optTour.size();

         int v = optTour.get(i);
         int w = optTour.get(j);

         double distance = distances[v][w];
         cost += distance;
      }

      bestCost = cost;



   }

   public int size() {
      return N;
   }

   public double optCost() {
      return bestCost;
   }

   public List<Integer> optTour() {
      return optTour;
   }

   public double distance(int v, int w) {
      return distances[v][w];
   }

   public Vector2D position(int v) {
      return points.get(v);
   }
}
