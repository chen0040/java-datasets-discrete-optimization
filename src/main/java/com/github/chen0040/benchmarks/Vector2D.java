package com.github.chen0040.benchmarks;


/**
 * Created by xschen on 14/6/2017.
 */
public class Vector2D {
   public final double x;
   public final double y;

   public Vector2D(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public double distanceSq(Vector2D that) {
      double dx = x - that.x;
      double dy = y - that.y;
      return dx * dx + dy * dy;
   }

   public double distance(Vector2D that){
      return Math.sqrt(distanceSq(that));
   }


   @Override public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      Vector2D vector2D = (Vector2D) o;

      if (Double.compare(vector2D.x, x) != 0)
         return false;
      return Double.compare(vector2D.y, y) == 0;
   }


   @Override public int hashCode() {
      int result;
      long temp;
      temp = Double.doubleToLongBits(x);
      result = (int) (temp ^ (temp >>> 32));
      temp = Double.doubleToLongBits(y);
      result = 31 * result + (int) (temp ^ (temp >>> 32));
      return result;
   }


   @Override public String toString() {
      return "(" + "x=" + x + ", y=" + y + ')';
   }
}
