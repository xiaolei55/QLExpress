package com.alibaba.qlexpress4.parser.tree;

import com.alibaba.qlexpress4.parser.Token;

public class PrefixUnaryOpExpr extends Expr {

    private final Expr expr;

    public PrefixUnaryOpExpr(Token keyToken, Expr expr) {
        super(keyToken);
        this.expr = expr;
    }

    public Expr getExpr() {
        return expr;
    }

    @Override
    public <R, C> R accept(QLProgramVisitor<R, C> visitor, C context) {
        return visitor.visit(this, context);
    }
}