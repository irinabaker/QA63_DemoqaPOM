package com.demoqa.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MyArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                arguments("Romebrt Weide","weide@gm.com","Berlin"),
                arguments("Romebrt1 Weide","weide@gm.com","Berlin"),
                arguments("Romebrt2 Weide","weide@gm.com","Berlin")
        );
    }
}
