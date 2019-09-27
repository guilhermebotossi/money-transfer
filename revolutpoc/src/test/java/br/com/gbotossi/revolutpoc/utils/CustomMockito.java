package br.com.gbotossi.revolutpoc.utils;

import org.mockito.Mockito;

import javax.persistence.TypedQuery;
import java.util.List;

public class CustomMockito extends Mockito {

    public static <T> List<T> mockList(Class<T> list) {
        return (List<T>) Mockito.mock(List.class, Mockito.withSettings());
    }

    public static <T> TypedQuery<T> mockTypedQuery(Class<T> list) {
        return (TypedQuery<T>) Mockito.mock(TypedQuery.class, Mockito.withSettings());
    }
}
