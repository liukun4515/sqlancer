package sqlancer.tidb.ast;

import sqlancer.Randomly;
import sqlancer.ast.BinaryOperatorNode;
import sqlancer.ast.BinaryOperatorNode.Operator;
import sqlancer.tidb.ast.TiDBBinaryLogicalOperation.TiDBBinaryLogicalOperator;

public class TiDBBinaryLogicalOperation extends BinaryOperatorNode<TiDBExpression, TiDBBinaryLogicalOperator>
		implements TiDBExpression {

	public static enum TiDBBinaryLogicalOperator implements Operator {
		AND("&"), //
		OR("|"), //
		XOR("^"), //
		LEFT_SHIFT("<<"), //
		RIGHT_SHIFT(">>");

		String textRepresentation;

		TiDBBinaryLogicalOperator(String textRepresentation) {
			this.textRepresentation = textRepresentation;
		}

		public static TiDBBinaryLogicalOperator getRandom() {
			return Randomly.fromOptions(values());
		}

		@Override
		public String getTextRepresentation() {
			return textRepresentation;
		}
	}

	public TiDBBinaryLogicalOperation(TiDBExpression left, TiDBExpression right, TiDBBinaryLogicalOperator op) {
		super(left, right, op);
	}

}