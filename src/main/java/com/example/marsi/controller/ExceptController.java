package com.example.marsi.controller;

import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping(path = "exp/")
public class ExceptController {

    @GetMapping("/")
    public String hello() {
        return "hej";
    }

    @GetMapping("/file/{filename}")
    public String getFilename(@PathVariable String filename) {
        return filename;
    }

    @GetMapping("/file/{filetext}")
    public String getFile(@PathVariable String filename) {
        String fileContent = "x";
        try {
            FileInputStream fs = new FileInputStream("c:/AFile/" + filename);
            try {
                byte[] bytes = fs.readAllBytes();
                fileContent = new String(bytes);
                System.out.println(fileContent);
            } catch (IOException ioerr) {
                System.out.println("IOExp ioerr=" + ioerr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT Found e=" + e.getMessage());
        }
        return fileContent;
    }


}
