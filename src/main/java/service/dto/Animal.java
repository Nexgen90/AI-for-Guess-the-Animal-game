package service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by nikolay.mikutskiy
 * Date: 05.07.2021
 */
@Getter
@RequiredArgsConstructor
public class Animal {
    private final String article;
    private final String name;

    @Override
    public String toString() {
        return article + " " + name;
    }
}
