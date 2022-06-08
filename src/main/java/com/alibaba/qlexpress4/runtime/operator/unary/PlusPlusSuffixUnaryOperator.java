package com.alibaba.qlexpress4.runtime.operator.unary;

import com.alibaba.qlexpress4.exception.ErrorReporter;
import com.alibaba.qlexpress4.runtime.LeftValue;
import com.alibaba.qlexpress4.runtime.Value;
import com.alibaba.qlexpress4.runtime.operator.base.BaseUnaryOperator;
import com.alibaba.qlexpress4.runtime.operator.number.NumberMath;

/**
 * @author 冰够
 */
public class PlusPlusSuffixUnaryOperator extends BaseUnaryOperator {
    @Override
    public String getOperator() {
        return "++";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public Object execute(Value value, ErrorReporter errorReporter) {
        Object operand = value.get();
        if (!NumberMath.isNumber(operand)) {
            throw buildInvalidOperandTypeException(value, errorReporter);
        }

        Number result = NumberMath.add((Number)operand, 1);
        if (value instanceof LeftValue) {
            ((LeftValue)value).set(result);
        }
        return result;
    }
}