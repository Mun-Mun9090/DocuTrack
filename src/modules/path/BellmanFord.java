package modules.path;

public class BellmanFord {

    public static void shortestPath(
            int cost[][],
            int source,
            String names[]) {

        int n = cost.length;
        int distance[] = new int[n];

        for(int i=0;i<n;i++)
            distance[i] = Dijkstra.INF;

        distance[source] = 0;

        for(int count=0;count<n-1;count++) {

            for(int u=0;u<n;u++) {

                for(int v=0;v<n;v++) {

                    if(cost[u][v] != Dijkstra.INF &&
                       distance[u] != Dijkstra.INF &&
                       distance[u] + cost[u][v] < distance[v]) {

                        distance[v] = distance[u] + cost[u][v];
                    }
                }
            }
        }

        System.out.println("Bellman-Ford Result:");

        for(int i=0;i<n;i++) {

            System.out.print(source + "(" + names[source] + ") to ");
            System.out.print(i + "(" + names[i] + ") = ");

            if(distance[i] == Dijkstra.INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }
}
