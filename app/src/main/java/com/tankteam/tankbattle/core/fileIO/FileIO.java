package com.tankteam.tankbattle.core.fileIO;

import com.tankteam.tankbattle.core.Input.Input;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by leiyong on 15/10/14.
 */
public interface FileIO {
    InputStream readAsset(String fileName) throws IOException;
    InputStream readFile(String fileName) throws IOException;
    OutputStream writeFile(String fileName) throws IOException;
}
