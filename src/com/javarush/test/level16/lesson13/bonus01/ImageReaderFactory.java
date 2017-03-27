package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

import static com.javarush.test.level16.lesson13.bonus01.common.ImageTypes.BMP;
import static com.javarush.test.level16.lesson13.bonus01.common.ImageTypes.JPG;
import static com.javarush.test.level16.lesson13.bonus01.common.ImageTypes.PNG;

/**
 * Created by 45 on 15.10.2016.
 */
public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes type) {

        if (type == JPG) {
            return new JpgReader();

        } else if (type == BMP) {
            return new BmpReader();

        } else if (type == PNG) {
            return new PngReader();

        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

    }

}