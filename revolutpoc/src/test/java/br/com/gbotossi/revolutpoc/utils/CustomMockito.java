package br.com.gbotossi.revolutpoc.utils;

import org.mockito.Mockito;

import java.util.List;

public class CustomMockito extends Mockito {

    public static <T> List<T> mockList(Class<T> list) {
        return (List<T>) Mockito.mock(List.class, Mockito.withSettings());
    }
}
