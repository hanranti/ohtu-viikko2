package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {

    private ArrayList<Matcher> matchers;

    public QueryBuilder() {
        matchers = new ArrayList<>();
    }

    public QueryBuilder playsIn(String team) {
        QueryBuilder queryBuilder = new QueryBuilder();
        matchers.add(new PlaysIn(team));
        queryBuilder.setMatchers(matchers);
        return queryBuilder;
    }

    public QueryBuilder hasAtLeast(int value, String item) {
        QueryBuilder queryBuilder = new QueryBuilder();
        matchers.add(new HasAtLeast(value, item));
        queryBuilder.setMatchers(matchers);
        return queryBuilder;
    }

    public QueryBuilder hasFewerThan(int value, String item) {
        QueryBuilder queryBuilder = new QueryBuilder();
        matchers.add(new HasFewerThan(value, item));
        queryBuilder.setMatchers(matchers);
        return queryBuilder;
    }

    public QueryBuilder and() {
        ArrayList<Matcher> matcherList = new ArrayList<>();
        matcherList.add(new And(matchers.toArray(new Matcher[matchers.size()])));
        matchers = matcherList;
        return this;
    }

    public QueryBuilder or(Matcher matcher) {
        ArrayList<Matcher> matcherList = new ArrayList<>();
        Matcher newMatcher = new And(matchers.toArray(new Matcher[matchers.size()]));
        matcherList.add(new Or(newMatcher, matcher));
        matchers = matcherList;
        return this;
    }

    public QueryBuilder not() {
        ArrayList<Matcher> matcherList = new ArrayList<>();
        matcherList.add(new Not(matchers.toArray(new Matcher[matchers.size()])));
        matchers = matcherList;
        return this;
    }

    public Matcher build() {
        return new And(matchers.toArray(new Matcher[matchers.size()]));
    }

    public void setMatchers(ArrayList<Matcher> newMatchers) {
        this.matchers = newMatchers;
    }
}
