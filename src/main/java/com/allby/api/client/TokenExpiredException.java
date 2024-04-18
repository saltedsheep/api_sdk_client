package com.allby.api.client;

public class TokenExpiredException extends Exception {
    private static final long serialVersionUID = 2341626709238942097L;

    public TokenExpiredException() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // 其他属性的哈希值计算
        return super.hashCode();
    }
}
