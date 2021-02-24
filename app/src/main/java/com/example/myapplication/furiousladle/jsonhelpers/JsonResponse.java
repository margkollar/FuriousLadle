package com.example.myapplication.furiousladle.jsonhelpers;

import java.util.List;
import java.util.Objects;

public class JsonResponse {
    private int from;
    private int to;
    private int count;
    private List<JsonResponseHit> hits;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<JsonResponseHit> getHit() {
        return hits;
    }

    public void setHit(List<JsonResponseHit> hits) {
        this.hits = hits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonResponse that = (JsonResponse) o;
        return from == that.from &&
                to == that.to &&
                count == that.count &&
                hits.equals(that.hits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, count, hits);
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "from=" + from +
                ", to=" + to +
                ", count=" + count +
                ", hits=" + hits +
                '}';
    }
}
