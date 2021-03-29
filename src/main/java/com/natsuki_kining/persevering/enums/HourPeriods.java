package com.natsuki_kining.persevering.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.natsuki_kining.persevering.converter.ConverterEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 * 十二时辰枚举
 *
 * @Author : natsuki_kining
 * @Date : 2020/10/25 16:20
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HourPeriods implements ConverterEnum, Serializable {
    /**
     * 【子时】夜半，又名子夜、中夜：十二时辰的第一个du时辰。（北京时zhi间23时至01时）。
     */
    ZI_SHI("子时","zi", 23, 23, 1),
    /**
     * 【丑时】鸡鸣，又名荒鸡：十二时辰的第二个时辰。（北京时间01时至03时）。
     */
    CHOU_SHI("丑时","chou", 1, 1, 3),
    /**
     * 【寅时】平旦，又称黎明、早晨、日旦等：时是夜与日的交替之际。（北京时间03时至05时）。
     */
    YIN_SHI("寅时", "yin",3, 3, 5),
    /**
     * 【卯时】日出，又名日始、破晓、旭日等：指太阳刚刚露脸，冉冉初升的那段时间。（北京时间05时至07时）。
     */
    MAO_SHI("卯时", "mao",5, 5, 7),
    /**
     * 【辰时】食时，又名早食等：古人“朝食”之时也就是吃早饭时间，（北京时间07时至09时）。
     */
    CHEN_SHI("辰时", "chen",7, 7, 9),
    /**
     * 【巳时】隅中，又名日禺等：临近中午的时候称为隅中。（北京时间09时至11时）。
     */
    SI_SHI("巳时", "si",9, 9, 11),
    /**
     * 【午时】日中，又名日正、中午等：（北京时间11时至13时）。
     */
    WU_SHI("午时", "wu",11, 11, 13),
    /**
     * 【未时】日昳，又名日跌、日央等：太阳偏西为日跌。（北京时间13时至15时）。
     */
    WEI_SHI("未时", "wei",13, 13, 15),
    /**
     * 【申时】哺时，又名日铺、夕食等：（北京时间15食至17时）。
     */
    SHEN_SHI("申时", "shen",15, 15, 17),
    /**
     * 【酉时】日入，又名日落、日沉、傍晚：意为太阳落山的时候。（北京时间17是至19时）。
     */
    YOU_SHI("酉时", "you",17, 17, 19),
    /**
     * 【戌时】黄昏，又名日夕、日暮、日晚等：此时太阳已经落山，天将黑未黑。天地昏黄，万物朦胧，故称黄昏。（北京时间19时至21时）。
     */
    XU_SHI("戌时", "xu",19, 19, 21),
    /**
     * 【亥时】人定，又名定昏等：此时夜色已深，人们也已经停止活动，安歇睡眠了。人定也就是人静。（北京时间21时至23时）。
     */
    HAI_SHI("亥时", "hai",21, 21, 23);

    private String name;
    private String code;
    private Integer value;

    /**
     * 对应的北京时间开始时间
     */
    private final int startTime;

    /**
     * 对应的北京时间结束时间
     */
    private final int endTime;

    HourPeriods(String name,String code, Integer value, int startTime, int endTime) {
        this.name = name;
        this.code = code;
        this.value = value;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * 使用@JsonCreator注解标记一个通过枚举码来查询枚举的方法，Jackson 会使用这个有参构造器进行反序列化
     * @param value
     * @return
     */
    @JsonCreator
    public static HourPeriods jsonCreator(Integer value) {
        for (HourPeriods hourPeriods : values()) {
            if (value.intValue() == hourPeriods.getValue().intValue()) {
                return hourPeriods;
            }
        }
        return null;
    }

    public static HourPeriods getHourPeriodsByCode(String code){
        for (HourPeriods hourPeriods : values()) {
            if (hourPeriods.getCode().equals(code)) {
                return hourPeriods;
            }
        }
        return null;
    }

}
