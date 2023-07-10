package com.nanib.language;

import java.util.HashMap;
import java.util.Map;

class JNanibInstance {
    private JNanibClass klass;
    private final Map<String, Object> fields = new HashMap<>();

    JNanibInstance(JNanibClass klass) {
        this.klass = klass;
    }

    void set(Token name, Object value) {
        fields.put(name.lexeme, value);
    }

    Object get(Token name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }

        JNanibFunction method = klass.findMethod(name.lexeme);
        if (method != null) return method.bind(this);

        throw new RuntimeError(name,
                "Undefined property '" + name.lexeme + "'.");
    }

    @Override
    public String toString() {
        return klass.name + " instance";
    }
}
