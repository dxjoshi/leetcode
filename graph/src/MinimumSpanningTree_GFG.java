import java.util.ArrayList;
import java.util.Collections;

public class MinimumSpanningTree_GFG {
    class Trio {
        int w;int u;int v;
        Trio(int w,int u,int v) {
            this.w=w;
            this.u=u;
            this.v=v;
        }
    }

    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)  {
        ArrayList<Trio> list = new ArrayList<>();
        int parent[]=new int[V];
        int rank[]=new int[V];
        int cost=0;

        for(int i=0;i<V;i++) parent[i]=i;

        for(int i=0;i<adj.size();i++) {
            for(ArrayList<Integer> x: adj.get(i)) {
                list.add(new Trio(x.get(1),i,x.get(0)));
            }
        }

        Collections.sort(list, (a, b) -> a.w -b.w);

        for(Trio trio:list) {
            if(getParent(trio.u,parent)!=getParent(trio.v,parent)) {
                cost+=trio.w;
                Union(trio.u,trio.v,parent,rank);
            }
        }

        return cost;
    }

    int getParent(int vertex,int parent[]) {
        if(vertex==parent[vertex]) return vertex;
        return parent[vertex]=getParent(parent[vertex],parent);
    }

    void Union(int u,int v,int parent[],int rank[]) {
        u = getParent(u,parent);
        v = getParent(v,parent);

        if(rank[u]<rank[v]) parent[u]=v;
        else if(rank[v]<rank[u]) parent[v]=u;
        else {
            parent[u]=v;
            rank[v]++;
        }
    }
}
