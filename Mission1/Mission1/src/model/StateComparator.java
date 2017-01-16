package model;
import java.util.Comparator;

public class StateComparator implements Comparator<Etat>
{
    @Override
    public int compare(Etat x, Etat y)
    {
        if (x.getHeuristique() < y.getHeuristique())
        {
            return -1;
        }
        if (x.getHeuristique() > y.getHeuristique())
        {
            return 1;
        }
        return 0;
    }
}