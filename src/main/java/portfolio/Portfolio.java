package portfolio;

import portfolio.investments.Investment;

import java.util.HashSet;
import java.util.Set;

public class Portfolio<T extends Investment> {
    private Set<T> portfolio = new HashSet<>();

    public boolean contains(T investment) {
        return portfolio.contains(investment);
    }

    public void buy(T investment) {
        if(!this.contains(investment)){
            portfolio.add(investment);
        }else {
            getShare(investment.getTitle()).setCount(getShare(investment.getTitle()).getCount() + 1);
        }
    }

    public void sell(String object, int i) {
        T investment = getShare(object);
        if(investment != null){
            investment.setCount(investment.getCount() - i);
            if(investment.getCount() <= 0) {
                portfolio.remove(investment);
            }
        }
    }

    public T getShare(String object) {
        for (T investment: portfolio) {
            if(investment.getTitle() == object){
                return investment;
            }
        }

        return null;
    }
}
