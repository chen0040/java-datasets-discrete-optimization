# java-datasets-discrete-optimization
Package provides datasets in the domain of discrete optimization

# Features

* TSP

# Install

Add the following dependency to your POM file:

```xml
<dependency>
  <groupId>com.github.chen0040</groupId>
  <artifactId>java-datasets-discrete-optimization</artifactId>
  <version>1.0.1</version>
</dependency>
```

# Usage

### TSP

The sample code below shows how to list all the TSP benchmarks:

```java
Tsp.Instance[] instances = Tsp.Instance.values();
      for(Tsp.Instance instance : instances){
         TspBenchmark benchmark = Tsp.get(instance);
      }
}
```

The sample code belows show how to obtain use the api of a TSP benchmark:

```java
TspBenchmark benchmark = Tsp.get(Tsp.Instance.a280);
System.out.println(benchmark.size());

for(int v = 0; v < benchmark.size(); ++v){
   System.out.println(benchmark.position(v)); // print the (x, y) coordinate of vertex v 
   for(int w = v+1; w < benchmark.size(); ++w) {
      System.out.println(benchmark.distance(v, w)); // symmetric distance between vertices v and w
   }
}

// optTour is the known optimal tour for which the last vertex is connected to the first vertex
for(Integer v : benchmark.optTour()){
   System.out.println(v);
}

System.out.println(benchmark.optCost()); // print the total distance of the known optimal tour
```
