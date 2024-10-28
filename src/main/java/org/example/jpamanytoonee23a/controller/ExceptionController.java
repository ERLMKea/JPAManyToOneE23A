package org.example.jpamanytoonee23a.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class ExceptionController {

    @GetMapping("/filex/{filename}")
    public String filex(@PathVariable String filename) throws IOException {
        String content = "";
            FileInputStream fs = new FileInputStream("c:/AFILE/" + filename);
                byte[] bytes = fs.readAllBytes();
                content = new String(bytes);
        return content;
    }

    @GetMapping("/file/{filename}")
    public String file(@PathVariable String filename) {
        String content = "";
        try {
            FileInputStream fs = new FileInputStream("c:/AFILE/" + filename);
            try {
                byte[] bytes = fs.readAllBytes();
                content = new String(bytes);
            } catch (Exception e) {
                return e.getMessage();
            }

        } catch (FileNotFoundException e) {
            String s = e.getMessage();
            s = s + " file: " + filename + " not found";
            return s;
        }
        return content;
    }


    @GetMapping("div/{divnum}")
    public String div(@PathVariable int divnum) {
        int i1 = 0;
        try {
            i1 = 100 / divnum;
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
        return "" + i1;
    }

    @GetMapping("divx/{divnum}")
    public String divx(@PathVariable int divnum) {
        int i1 = 0;
        i1 = 100 / divnum;
        return "" + i1;
    }

    @GetMapping("loopnot/{loopnum}")
    public String durikke(@PathVariable int loopnum) {
        int x = 0;
        try {
            for (int i = 0; i < loopnum; i++) {
                x++;
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "" + x;
    }

    @GetMapping("loop/{loopnum}")
    public String loop(@PathVariable String loopnum) {
        int x = 0;
        int y = 0;
        try {
            x = Integer.parseInt(loopnum);
            for (int i = 0; i < x; i++) {
                y++;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return e.getClass().getName() + " : " + e.getMessage();
        }
        return "" + x;
    }





}
