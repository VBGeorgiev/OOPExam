package com.oopexam.services;

import com.oopexam.database.Reader;
import com.oopexam.database.Writer;


public abstract class Service {
    public Reader reader;
    public Writer writer;

    public Service(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Reader getReader() {
        return reader;
    }

    public Writer getWriter() {
        return writer;
    }
}
