package com.typeconverter;

import com.typeconverter.converter.IntegerToStringConverter;
import com.typeconverter.converter.IpPortToStringConverter;
import com.typeconverter.converter.StringToIntegerConverter;
import com.typeconverter.converter.StringToIpPortConverter;
import com.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 기본으로 되어 있지만 ip 변환과 같은 것은 커스텀이 필요
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        // 둘다 하면 우선순위가 converter가 적용되어 formatter는 적용이 안됨
        // registry.addConverter(new StringToIntegerConverter());
        // registry.addConverter(new IntegerToStringConverter());
        registry.addFormatter(new MyNumberFormatter());
    }
}
