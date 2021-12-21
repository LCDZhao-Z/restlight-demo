package test.spi;

import io.esastack.restlight.core.method.Param;
import io.esastack.restlight.core.resolver.StringConverter;
import io.esastack.restlight.core.resolver.StringConverterFactory;
import io.esastack.restlight.core.util.ConverterUtils;

import java.lang.reflect.Type;
import java.util.Optional;
import java.util.function.Function;

public class CustomStringConverterFactory implements StringConverterFactory {
    @Override
    public Optional<StringConverter> createConverter(Class<?> type, Type genericType, Param relatedParam) {
        Function<String, Object> converter = null;
        if (genericType != null) {
            converter = ConverterUtils.str2ObjectConverter(genericType);
        } else if (type != null) {
            converter = ConverterUtils.str2ObjectConverter(type);
        }

        if (converter == null) {
            return Optional.empty();
        }

        Function<String, Object> finalConverter = converter;
        return Optional.of(new StringConverter() {
            @Override
            public Object fromString(String value) {
                System.out.println("-------------------------fromString-----------------");
                return finalConverter.apply(value);
            }

            @Override
            public boolean isLazy() {
                return true;
            }
        });
    }
}
