package com.nanib.language;

import java.util.List;

interface JNanibCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}
