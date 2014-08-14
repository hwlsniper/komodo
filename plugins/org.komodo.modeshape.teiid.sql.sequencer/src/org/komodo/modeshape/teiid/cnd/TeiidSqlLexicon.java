/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */

package org.komodo.modeshape.teiid.cnd;

import java.lang.reflect.Field;import java.util.HashMap;import java.util.Map;import org.komodo.modeshape.teiid.sql.lang.ASTNode;import org.komodo.spi.constants.StringConstants;

@SuppressWarnings( { "javadoc", "nls" })
public class TeiidSqlLexicon implements StringConstants {

	interface Namespace {
		public static final String PREFIX = "tsql";
		public static final String URI = "http://www.teiid.org/sql/1.0";
	}

	/**
	 * tsql:languageObject
	 */
	public interface LanguageObject {

		String ID = Namespace.PREFIX + COLON + "languageObject";

	}

	/**
	 * tsql:expression
	 */
	public interface Expression extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "expression";

	}

	/**
	 * tsql:predicateCriteria
	 */
	public interface PredicateCriteria extends Expression {

		String ID = Namespace.PREFIX + COLON + "predicateCriteria";

	}

	/**
	 * tsql:subqueryContainer
	 */
	public interface SubqueryContainer extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "subqueryContainer";

	}

	/**
	 * tsql:labeled
	 */
	public interface Labeled {

		String ID = Namespace.PREFIX + COLON + "labeled";

	}

	/**
	 * tsql:targetedCommand
	 */
	public interface TargetedCommand {

		String ID = Namespace.PREFIX + COLON + "targetedCommand";

	}

	/**
	 * tsql:expressionStatement
	 */
	public interface ExpressionStatement {

		String ID = Namespace.PREFIX + COLON + "expressionStatement";

	}

	/**
	 * tsql:criteria
	 */
	public interface Criteria extends Expression {

		String ID = Namespace.PREFIX + COLON + "criteria";

		boolean IS_ABSTRACT = false;

	}

	/**
	 * tsql:abstractCompareCriteria
	 */
	public interface AbstractCompareCriteria extends Criteria, PredicateCriteria {

		String ID = Namespace.PREFIX + COLON + "abstractCompareCriteria";

		boolean IS_ABSTRACT = true;

		/**
		 * OPERATOR Property
		 */
		String OPERATOR_PROP_NAME = Namespace.PREFIX + COLON + "operator";

		Class<?> OPERATOR_PROP_TYPE =  String.class;

		boolean OPERATOR_PROP_MULTIPLE = false;

		String[] OPERATOR_PROP_CONSTRAINTS = { "=", "<>", "!=", "<", ">", "<=", ">=" };

		/**
		 * LEFT_EXPRESSION Reference
		 */
		String LEFT_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "leftExpression";

		Class<?> LEFT_EXPRESSION_REF_TYPE =  Expression.class;

		boolean LEFT_EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:compareCriteria
	 */
	public interface CompareCriteria extends AbstractCompareCriteria {

		String ID = Namespace.PREFIX + COLON + "compareCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * OPTIONAL Property
		 */
		String OPTIONAL_PROP_NAME = Namespace.PREFIX + COLON + "optional";

		Class<?> OPTIONAL_PROP_TYPE =  Boolean.class;

		boolean OPTIONAL_PROP_MULTIPLE = false;

		/**
		 * OPERATOR Property
		 */
		String OPERATOR_PROP_NAME = Namespace.PREFIX + COLON + "operator";

		Class<?> OPERATOR_PROP_TYPE =  Long.class;

		boolean OPERATOR_PROP_MULTIPLE = false;

		/**
		 * RIGHT_EXPRESSION Reference
		 */
		String RIGHT_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "rightExpression";

		Class<?> RIGHT_EXPRESSION_REF_TYPE =  Expression.class;

		boolean RIGHT_EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:subqueryCompareCriteria
	 */
	public interface SubqueryCompareCriteria extends AbstractCompareCriteria, SubqueryContainer {

		String ID = Namespace.PREFIX + COLON + "subqueryCompareCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * PREDICATE_QUANTIFIER Property
		 */
		String PREDICATE_QUANTIFIER_PROP_NAME = Namespace.PREFIX + COLON + "predicateQuantifier";

		Class<?> PREDICATE_QUANTIFIER_PROP_TYPE =  String.class;

		boolean PREDICATE_QUANTIFIER_PROP_MULTIPLE = false;

		String[] PREDICATE_QUANTIFIER_PROP_CONSTRAINTS = { "SOME", "ANY", "ALL" };

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  QueryCommand.class;

		boolean COMMAND_REF_MULTIPLE = false;

	}

	/**
	 * tsql:abstractSetCriteria
	 */
	public interface AbstractSetCriteria extends Criteria, PredicateCriteria {

		String ID = Namespace.PREFIX + COLON + "abstractSetCriteria";

		boolean IS_ABSTRACT = true;

		/**
		 * NEGATED Property
		 */
		String NEGATED_PROP_NAME = Namespace.PREFIX + COLON + "negated";

		Class<?> NEGATED_PROP_TYPE =  Boolean.class;

		boolean NEGATED_PROP_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:setCriteria
	 */
	public interface SetCriteria extends AbstractSetCriteria {

		String ID = Namespace.PREFIX + COLON + "setCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * VALUES Reference
		 */
		String VALUES_REF_NAME = Namespace.PREFIX + COLON + "values";

		Class<?> VALUES_REF_TYPE =  Expression.class;

		boolean VALUES_REF_MULTIPLE = true;

	}

	/**
	 * tsql:subquerySetCriteria
	 */
	public interface SubquerySetCriteria extends AbstractSetCriteria, SubqueryContainer {

		String ID = Namespace.PREFIX + COLON + "subquerySetCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  QueryCommand.class;

		boolean COMMAND_REF_MULTIPLE = false;

		/**
		 * SUBQUERY_HINT Reference
		 */
		String SUBQUERY_HINT_REF_NAME = Namespace.PREFIX + COLON + "subqueryHint";

		Class<?> SUBQUERY_HINT_REF_TYPE =  SubqueryHint.class;

		boolean SUBQUERY_HINT_REF_MULTIPLE = false;

	}

	/**
	 * tsql:betweenCriteria
	 */
	public interface BetweenCriteria extends Criteria, PredicateCriteria {

		String ID = Namespace.PREFIX + COLON + "betweenCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * NEGATED Property
		 */
		String NEGATED_PROP_NAME = Namespace.PREFIX + COLON + "negated";

		Class<?> NEGATED_PROP_TYPE =  Boolean.class;

		boolean NEGATED_PROP_MULTIPLE = false;

		/**
		 * LOWER_EXPRESSION Reference
		 */
		String LOWER_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "lowerExpression";

		Class<?> LOWER_EXPRESSION_REF_TYPE =  Expression.class;

		boolean LOWER_EXPRESSION_REF_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

		/**
		 * UPPER_EXPRESSION Reference
		 */
		String UPPER_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "upperExpression";

		Class<?> UPPER_EXPRESSION_REF_TYPE =  Expression.class;

		boolean UPPER_EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:compoundCriteria
	 */
	public interface CompoundCriteria extends Criteria {

		String ID = Namespace.PREFIX + COLON + "compoundCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * OPERATOR Property
		 */
		String OPERATOR_PROP_NAME = Namespace.PREFIX + COLON + "operator";

		Class<?> OPERATOR_PROP_TYPE =  Long.class;

		boolean OPERATOR_PROP_MULTIPLE = false;

		/**
		 * CRITERIA Reference
		 */
		String CRITERIA_REF_NAME = Namespace.PREFIX + COLON + "criteria";

		Class<?> CRITERIA_REF_TYPE =  Criteria.class;

		boolean CRITERIA_REF_MULTIPLE = true;

	}

	/**
	 * tsql:existsCriteria
	 */
	public interface ExistsCriteria extends Criteria, PredicateCriteria, SubqueryContainer {

		String ID = Namespace.PREFIX + COLON + "existsCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * NEGATED Property
		 */
		String NEGATED_PROP_NAME = Namespace.PREFIX + COLON + "negated";

		Class<?> NEGATED_PROP_TYPE =  Boolean.class;

		boolean NEGATED_PROP_MULTIPLE = false;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  QueryCommand.class;

		boolean COMMAND_REF_MULTIPLE = false;

		/**
		 * SUBQUERY_HINT Reference
		 */
		String SUBQUERY_HINT_REF_NAME = Namespace.PREFIX + COLON + "subqueryHint";

		Class<?> SUBQUERY_HINT_REF_TYPE =  SubqueryHint.class;

		boolean SUBQUERY_HINT_REF_MULTIPLE = false;

	}

	/**
	 * tsql:expressionCriteria
	 */
	public interface ExpressionCriteria extends Criteria {

		String ID = Namespace.PREFIX + COLON + "expressionCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:isNullCriteria
	 */
	public interface IsNullCriteria extends Criteria, PredicateCriteria {

		String ID = Namespace.PREFIX + COLON + "isNullCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * NEGATED Property
		 */
		String NEGATED_PROP_NAME = Namespace.PREFIX + COLON + "negated";

		Class<?> NEGATED_PROP_TYPE =  Boolean.class;

		boolean NEGATED_PROP_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:matchCriteria
	 */
	public interface MatchCriteria extends Criteria, PredicateCriteria {

		String ID = Namespace.PREFIX + COLON + "matchCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * NEGATED Property
		 */
		String NEGATED_PROP_NAME = Namespace.PREFIX + COLON + "negated";

		Class<?> NEGATED_PROP_TYPE =  Boolean.class;

		boolean NEGATED_PROP_MULTIPLE = false;

		/**
		 * ESCAPE_CHAR Property
		 */
		String ESCAPE_CHAR_PROP_NAME = Namespace.PREFIX + COLON + "escapeChar";

		Class<?> ESCAPE_CHAR_PROP_TYPE =  String.class;

		boolean ESCAPE_CHAR_PROP_MULTIPLE = false;

		/**
		 * LEFT_EXPRESSION Reference
		 */
		String LEFT_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "leftExpression";

		Class<?> LEFT_EXPRESSION_REF_TYPE =  Expression.class;

		boolean LEFT_EXPRESSION_REF_MULTIPLE = false;

		/**
		 * RIGHT_EXPRESSION Reference
		 */
		String RIGHT_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "rightExpression";

		Class<?> RIGHT_EXPRESSION_REF_TYPE =  Expression.class;

		boolean RIGHT_EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:notCriteria
	 */
	public interface NotCriteria extends Criteria {

		String ID = Namespace.PREFIX + COLON + "notCriteria";

		boolean IS_ABSTRACT = false;

		/**
		 * CRITERIA Reference
		 */
		String CRITERIA_REF_NAME = Namespace.PREFIX + COLON + "criteria";

		Class<?> CRITERIA_REF_TYPE =  Criteria.class;

		boolean CRITERIA_REF_MULTIPLE = false;

	}

	/**
	 * tsql:command
	 */
	public interface Command extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "command";

		boolean IS_ABSTRACT = true;

		/**
		 * IS_RESOLVED Property
		 */
		String IS_RESOLVED_PROP_NAME = Namespace.PREFIX + COLON + "isResolved";

		Class<?> IS_RESOLVED_PROP_TYPE =  Boolean.class;

		boolean IS_RESOLVED_PROP_MULTIPLE = false;

		/**
		 * SOURCE_HINT Reference
		 */
		String SOURCE_HINT_REF_NAME = Namespace.PREFIX + COLON + "sourceHint";

		Class<?> SOURCE_HINT_REF_TYPE =  SourceHint.class;

		boolean SOURCE_HINT_REF_MULTIPLE = false;

		/**
		 * OPTION Reference
		 */
		String OPTION_REF_NAME = Namespace.PREFIX + COLON + "option";

		Class<?> OPTION_REF_TYPE =  Option.class;

		boolean OPTION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:alter
	 */
	public interface Alter extends Command {

		String ID = Namespace.PREFIX + COLON + "alter";

		boolean IS_ABSTRACT = true;

		/**
		 * DEFINITION Reference
		 */
		String DEFINITION_REF_NAME = Namespace.PREFIX + COLON + "definition";

		Class<?> DEFINITION_REF_TYPE =  Command.class;

		boolean DEFINITION_REF_MULTIPLE = false;

		/**
		 * TARGET Reference
		 */
		String TARGET_REF_NAME = Namespace.PREFIX + COLON + "target";

		Class<?> TARGET_REF_TYPE =  GroupSymbol.class;

		boolean TARGET_REF_MULTIPLE = false;

	}

	/**
	 * tsql:alterProcedure
	 */
	public interface AlterProcedure extends Alter {

		String ID = Namespace.PREFIX + COLON + "alterProcedure";

		boolean IS_ABSTRACT = false;

	}

	/**
	 * tsql:alterTrigger
	 */
	public interface AlterTrigger extends Alter {

		String ID = Namespace.PREFIX + COLON + "alterTrigger";

		boolean IS_ABSTRACT = false;

		/**
		 * EVENT Property
		 */
		String EVENT_PROP_NAME = Namespace.PREFIX + COLON + "event";

		Class<?> EVENT_PROP_TYPE =  String.class;

		boolean EVENT_PROP_MULTIPLE = false;

		String[] EVENT_PROP_CONSTRAINTS = { "INSERT", "UPDATE", "DELETE" };

		/**
		 * ENABLED Property
		 */
		String ENABLED_PROP_NAME = Namespace.PREFIX + COLON + "enabled";

		Class<?> ENABLED_PROP_TYPE =  Boolean.class;

		boolean ENABLED_PROP_MULTIPLE = false;

		/**
		 * CREATE Property
		 */
		String CREATE_PROP_NAME = Namespace.PREFIX + COLON + "create";

		Class<?> CREATE_PROP_TYPE =  Boolean.class;

		boolean CREATE_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:alterView
	 */
	public interface AlterView extends Alter {

		String ID = Namespace.PREFIX + COLON + "alterView";

		boolean IS_ABSTRACT = false;

	}

	/**
	 * tsql:procedureContainer
	 */
	public interface ProcedureContainer extends Command {

		String ID = Namespace.PREFIX + COLON + "procedureContainer";

		boolean IS_ABSTRACT = true;

	}

	/**
	 * tsql:delete
	 */
	public interface Delete extends ProcedureContainer, TargetedCommand {

		String ID = Namespace.PREFIX + COLON + "delete";

		boolean IS_ABSTRACT = false;

		/**
		 * CRITERIA Reference
		 */
		String CRITERIA_REF_NAME = Namespace.PREFIX + COLON + "criteria";

		Class<?> CRITERIA_REF_TYPE =  Criteria.class;

		boolean CRITERIA_REF_MULTIPLE = false;

		/**
		 * GROUP Reference
		 */
		String GROUP_REF_NAME = Namespace.PREFIX + COLON + "group";

		Class<?> GROUP_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:insert
	 */
	public interface Insert extends ProcedureContainer, TargetedCommand {

		String ID = Namespace.PREFIX + COLON + "insert";

		boolean IS_ABSTRACT = false;

		/**
		 * MERGE Property
		 */
		String MERGE_PROP_NAME = Namespace.PREFIX + COLON + "merge";

		Class<?> MERGE_PROP_TYPE =  Boolean.class;

		boolean MERGE_PROP_MULTIPLE = false;

		/**
		 * QUERY_EXPRESSION Reference
		 */
		String QUERY_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "queryExpression";

		Class<?> QUERY_EXPRESSION_REF_TYPE =  QueryCommand.class;

		boolean QUERY_EXPRESSION_REF_MULTIPLE = false;

		/**
		 * VALUES Reference
		 */
		String VALUES_REF_NAME = Namespace.PREFIX + COLON + "values";

		Class<?> VALUES_REF_TYPE =  Expression.class;

		boolean VALUES_REF_MULTIPLE = true;

		/**
		 * VARIABLES Reference
		 */
		String VARIABLES_REF_NAME = Namespace.PREFIX + COLON + "variables";

		Class<?> VARIABLES_REF_TYPE =  ElementSymbol.class;

		boolean VARIABLES_REF_MULTIPLE = true;

		/**
		 * GROUP Reference
		 */
		String GROUP_REF_NAME = Namespace.PREFIX + COLON + "group";

		Class<?> GROUP_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:storedProcedure
	 */
	public interface StoredProcedure extends ProcedureContainer, TargetedCommand {

		String ID = Namespace.PREFIX + COLON + "storedProcedure";

		boolean IS_ABSTRACT = false;

		/**
		 * DISPLAY_NAMED_PARAMETERS Property
		 */
		String DISPLAY_NAMED_PARAMETERS_PROP_NAME = Namespace.PREFIX + COLON + "displayNamedParameters";

		Class<?> DISPLAY_NAMED_PARAMETERS_PROP_TYPE =  Boolean.class;

		boolean DISPLAY_NAMED_PARAMETERS_PROP_MULTIPLE = false;

		/**
		 * CALLED_WITH_RETURN Property
		 */
		String CALLED_WITH_RETURN_PROP_NAME = Namespace.PREFIX + COLON + "calledWithReturn";

		Class<?> CALLED_WITH_RETURN_PROP_TYPE =  Boolean.class;

		boolean CALLED_WITH_RETURN_PROP_MULTIPLE = false;

		/**
		 * CALLABLE_STATEMENT Property
		 */
		String CALLABLE_STATEMENT_PROP_NAME = Namespace.PREFIX + COLON + "callableStatement";

		Class<?> CALLABLE_STATEMENT_PROP_TYPE =  Boolean.class;

		boolean CALLABLE_STATEMENT_PROP_MULTIPLE = false;

		/**
		 * PROCEDURE_NAME Property
		 */
		String PROCEDURE_NAME_PROP_NAME = Namespace.PREFIX + COLON + "procedureName";

		Class<?> PROCEDURE_NAME_PROP_TYPE =  String.class;

		boolean PROCEDURE_NAME_PROP_MULTIPLE = false;

		/**
		 * PROCEDUREID Property
		 */
		String PROCEDUREID_PROP_NAME = Namespace.PREFIX + COLON + "procedureID";

		Class<?> PROCEDUREID_PROP_TYPE =  Object.class;

		boolean PROCEDUREID_PROP_MULTIPLE = false;

		/**
		 * PARAMETER Reference
		 */
		String PARAMETER_REF_NAME = Namespace.PREFIX + COLON + "parameter";

		Class<?> PARAMETER_REF_TYPE =  SPParameter.class;

		boolean PARAMETER_REF_MULTIPLE = false;

		/**
		 * GROUP Reference
		 */
		String GROUP_REF_NAME = Namespace.PREFIX + COLON + "group";

		Class<?> GROUP_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:update
	 */
	public interface Update extends ProcedureContainer, TargetedCommand {

		String ID = Namespace.PREFIX + COLON + "update";

		boolean IS_ABSTRACT = false;

		/**
		 * CHANGE_LIST Reference
		 */
		String CHANGE_LIST_REF_NAME = Namespace.PREFIX + COLON + "changeList";

		Class<?> CHANGE_LIST_REF_TYPE =  SetClauseList.class;

		boolean CHANGE_LIST_REF_MULTIPLE = false;

		/**
		 * CRITERIA Reference
		 */
		String CRITERIA_REF_NAME = Namespace.PREFIX + COLON + "criteria";

		Class<?> CRITERIA_REF_TYPE =  Criteria.class;

		boolean CRITERIA_REF_MULTIPLE = false;

		/**
		 * GROUP Reference
		 */
		String GROUP_REF_NAME = Namespace.PREFIX + COLON + "group";

		Class<?> GROUP_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:dynamicCommand
	 */
	public interface DynamicCommand extends Command {

		String ID = Namespace.PREFIX + COLON + "dynamicCommand";

		boolean IS_ABSTRACT = false;

		/**
		 * AS_CLAUSE_SET Property
		 */
		String AS_CLAUSE_SET_PROP_NAME = Namespace.PREFIX + COLON + "asClauseSet";

		Class<?> AS_CLAUSE_SET_PROP_TYPE =  Boolean.class;

		boolean AS_CLAUSE_SET_PROP_MULTIPLE = false;

		/**
		 * UPDATING_MODEL_COUNT Property
		 */
		String UPDATING_MODEL_COUNT_PROP_NAME = Namespace.PREFIX + COLON + "updatingModelCount";

		Class<?> UPDATING_MODEL_COUNT_PROP_TYPE =  Long.class;

		boolean UPDATING_MODEL_COUNT_PROP_MULTIPLE = false;

		/**
		 * AS_COLUMNS Reference
		 */
		String AS_COLUMNS_REF_NAME = Namespace.PREFIX + COLON + "asColumns";

		Class<?> AS_COLUMNS_REF_TYPE =  ElementSymbol.class;

		boolean AS_COLUMNS_REF_MULTIPLE = true;

		/**
		 * USING Reference
		 */
		String USING_REF_NAME = Namespace.PREFIX + COLON + "using";

		Class<?> USING_REF_TYPE =  SetClauseList.class;

		boolean USING_REF_MULTIPLE = false;

		/**
		 * SQL Reference
		 */
		String SQL_REF_NAME = Namespace.PREFIX + COLON + "sql";

		Class<?> SQL_REF_TYPE =  Expression.class;

		boolean SQL_REF_MULTIPLE = false;

		/**
		 * INTO_GROUP Reference
		 */
		String INTO_GROUP_REF_NAME = Namespace.PREFIX + COLON + "intoGroup";

		Class<?> INTO_GROUP_REF_TYPE =  GroupSymbol.class;

		boolean INTO_GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:queryCommand
	 */
	public interface QueryCommand extends Command {

		String ID = Namespace.PREFIX + COLON + "queryCommand";

		boolean IS_ABSTRACT = true;

		/**
		 * WITH Reference
		 */
		String WITH_REF_NAME = Namespace.PREFIX + COLON + "with";

		Class<?> WITH_REF_TYPE =  WithQueryCommand.class;

		boolean WITH_REF_MULTIPLE = true;

		/**
		 * ORDER_BY Reference
		 */
		String ORDER_BY_REF_NAME = Namespace.PREFIX + COLON + "orderBy";

		Class<?> ORDER_BY_REF_TYPE =  OrderBy.class;

		boolean ORDER_BY_REF_MULTIPLE = false;

		/**
		 * LIMIT Reference
		 */
		String LIMIT_REF_NAME = Namespace.PREFIX + COLON + "limit";

		Class<?> LIMIT_REF_TYPE =  Limit.class;

		boolean LIMIT_REF_MULTIPLE = false;

	}

	/**
	 * tsql:query
	 */
	public interface Query extends QueryCommand {

		String ID = Namespace.PREFIX + COLON + "query";

		boolean IS_ABSTRACT = false;

		/**
		 * ROW_CONSTRUCTOR Property
		 */
		String ROW_CONSTRUCTOR_PROP_NAME = Namespace.PREFIX + COLON + "rowConstructor";

		Class<?> ROW_CONSTRUCTOR_PROP_TYPE =  Boolean.class;

		boolean ROW_CONSTRUCTOR_PROP_MULTIPLE = false;

		/**
		 * INTO Reference
		 */
		String INTO_REF_NAME = Namespace.PREFIX + COLON + "into";

		Class<?> INTO_REF_TYPE =  Into.class;

		boolean INTO_REF_MULTIPLE = false;

		/**
		 * HAVING Reference
		 */
		String HAVING_REF_NAME = Namespace.PREFIX + COLON + "having";

		Class<?> HAVING_REF_TYPE =  Criteria.class;

		boolean HAVING_REF_MULTIPLE = false;

		/**
		 * GROUP_BY Reference
		 */
		String GROUP_BY_REF_NAME = Namespace.PREFIX + COLON + "groupBy";

		Class<?> GROUP_BY_REF_TYPE =  GroupBy.class;

		boolean GROUP_BY_REF_MULTIPLE = false;

		/**
		 * FROM Reference
		 */
		String FROM_REF_NAME = Namespace.PREFIX + COLON + "from";

		Class<?> FROM_REF_TYPE =  From.class;

		boolean FROM_REF_MULTIPLE = false;

		/**
		 * CRITERIA Reference
		 */
		String CRITERIA_REF_NAME = Namespace.PREFIX + COLON + "criteria";

		Class<?> CRITERIA_REF_TYPE =  Criteria.class;

		boolean CRITERIA_REF_MULTIPLE = false;

		/**
		 * SELECT Reference
		 */
		String SELECT_REF_NAME = Namespace.PREFIX + COLON + "select";

		Class<?> SELECT_REF_TYPE =  Select.class;

		boolean SELECT_REF_MULTIPLE = false;

	}

	/**
	 * tsql:setQuery
	 */
	public interface SetQuery extends QueryCommand {

		String ID = Namespace.PREFIX + COLON + "setQuery";

		boolean IS_ABSTRACT = false;

		/**
		 * ALL Property
		 */
		String ALL_PROP_NAME = Namespace.PREFIX + COLON + "all";

		Class<?> ALL_PROP_TYPE =  Boolean.class;

		boolean ALL_PROP_MULTIPLE = false;

		/**
		 * LEFT_QUERY Reference
		 */
		String LEFT_QUERY_REF_NAME = Namespace.PREFIX + COLON + "leftQuery";

		Class<?> LEFT_QUERY_REF_TYPE =  QueryCommand.class;

		boolean LEFT_QUERY_REF_MULTIPLE = false;

		/**
		 * RIGHT_QUERY Reference
		 */
		String RIGHT_QUERY_REF_NAME = Namespace.PREFIX + COLON + "rightQuery";

		Class<?> RIGHT_QUERY_REF_TYPE =  QueryCommand.class;

		boolean RIGHT_QUERY_REF_MULTIPLE = false;

	}

	/**
	 * tsql:createProcedureCommand
	 */
	public interface CreateProcedureCommand extends Command {

		String ID = Namespace.PREFIX + COLON + "createProcedureCommand";

		boolean IS_ABSTRACT = false;

		/**
		 * BLOCK Reference
		 */
		String BLOCK_REF_NAME = Namespace.PREFIX + COLON + "block";

		Class<?> BLOCK_REF_TYPE =  Block.class;

		boolean BLOCK_REF_MULTIPLE = false;

		/**
		 * VIRTUAL_GROUP Reference
		 */
		String VIRTUAL_GROUP_REF_NAME = Namespace.PREFIX + COLON + "virtualGroup";

		Class<?> VIRTUAL_GROUP_REF_TYPE =  GroupSymbol.class;

		boolean VIRTUAL_GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:triggerAction
	 */
	public interface TriggerAction extends Command {

		String ID = Namespace.PREFIX + COLON + "triggerAction";

		boolean IS_ABSTRACT = false;

		/**
		 * BLOCK Reference
		 */
		String BLOCK_REF_NAME = Namespace.PREFIX + COLON + "block";

		Class<?> BLOCK_REF_TYPE =  Block.class;

		boolean BLOCK_REF_MULTIPLE = false;

	}

	/**
	 * tsql:fromClause
	 */
	public interface FromClause extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "fromClause";

		boolean IS_ABSTRACT = true;

		/**
		 * PRESERVE Property
		 */
		String PRESERVE_PROP_NAME = Namespace.PREFIX + COLON + "preserve";

		Class<?> PRESERVE_PROP_TYPE =  Boolean.class;

		boolean PRESERVE_PROP_MULTIPLE = false;

		/**
		 * MAKE_DEP Property
		 */
		String MAKE_DEP_PROP_NAME = Namespace.PREFIX + COLON + "makeDep";

		Class<?> MAKE_DEP_PROP_TYPE =  Boolean.class;

		boolean MAKE_DEP_PROP_MULTIPLE = false;

		/**
		 * OPTIONAL Property
		 */
		String OPTIONAL_PROP_NAME = Namespace.PREFIX + COLON + "optional";

		Class<?> OPTIONAL_PROP_TYPE =  Boolean.class;

		boolean OPTIONAL_PROP_MULTIPLE = false;

		/**
		 * MAX Property
		 */
		String MAX_PROP_NAME = Namespace.PREFIX + COLON + "max";

		Class<?> MAX_PROP_TYPE =  Boolean.class;

		boolean MAX_PROP_MULTIPLE = false;

		/**
		 * JOIN Property
		 */
		String JOIN_PROP_NAME = Namespace.PREFIX + COLON + "join";

		Class<?> JOIN_PROP_TYPE =  Boolean.class;

		boolean JOIN_PROP_MULTIPLE = false;

		/**
		 * MAKE_NOT_DEP Property
		 */
		String MAKE_NOT_DEP_PROP_NAME = Namespace.PREFIX + COLON + "makeNotDep";

		Class<?> MAKE_NOT_DEP_PROP_TYPE =  Boolean.class;

		boolean MAKE_NOT_DEP_PROP_MULTIPLE = false;

		/**
		 * MAKE_IND Property
		 */
		String MAKE_IND_PROP_NAME = Namespace.PREFIX + COLON + "makeInd";

		Class<?> MAKE_IND_PROP_TYPE =  Boolean.class;

		boolean MAKE_IND_PROP_MULTIPLE = false;

		/**
		 * NO_UNNEST Property
		 */
		String NO_UNNEST_PROP_NAME = Namespace.PREFIX + COLON + "noUnnest";

		Class<?> NO_UNNEST_PROP_TYPE =  Boolean.class;

		boolean NO_UNNEST_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:tableFunctionReference
	 */
	public interface TableFunctionReference extends FromClause {

		String ID = Namespace.PREFIX + COLON + "tableFunctionReference";

		boolean IS_ABSTRACT = true;

		/**
		 * NAME Property
		 */
		String NAME_PROP_NAME = Namespace.PREFIX + COLON + "name";

		Class<?> NAME_PROP_TYPE =  String.class;

		boolean NAME_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:arrayTable
	 */
	public interface ArrayTable extends TableFunctionReference {

		String ID = Namespace.PREFIX + COLON + "arrayTable";

		boolean IS_ABSTRACT = false;

		/**
		 * COLUMNS Reference
		 */
		String COLUMNS_REF_NAME = Namespace.PREFIX + COLON + "columns";

		Class<?> COLUMNS_REF_TYPE =  ProjectedColumn.class;

		boolean COLUMNS_REF_MULTIPLE = true;

		/**
		 * ARRAY_VALUE Reference
		 */
		String ARRAY_VALUE_REF_NAME = Namespace.PREFIX + COLON + "arrayValue";

		Class<?> ARRAY_VALUE_REF_TYPE =  Expression.class;

		boolean ARRAY_VALUE_REF_MULTIPLE = false;

	}

	/**
	 * tsql:objectTable
	 */
	public interface ObjectTable extends TableFunctionReference {

		String ID = Namespace.PREFIX + COLON + "objectTable";

		boolean IS_ABSTRACT = false;

		/**
		 * ROW_SCRIPT Property
		 */
		String ROW_SCRIPT_PROP_NAME = Namespace.PREFIX + COLON + "rowScript";

		Class<?> ROW_SCRIPT_PROP_TYPE =  String.class;

		boolean ROW_SCRIPT_PROP_MULTIPLE = false;

		/**
		 * SCRIPTING_LANGUAGE Property
		 */
		String SCRIPTING_LANGUAGE_PROP_NAME = Namespace.PREFIX + COLON + "scriptingLanguage";

		Class<?> SCRIPTING_LANGUAGE_PROP_TYPE =  String.class;

		boolean SCRIPTING_LANGUAGE_PROP_MULTIPLE = false;

		/**
		 * COLUMNS Reference
		 */
		String COLUMNS_REF_NAME = Namespace.PREFIX + COLON + "columns";

		Class<?> COLUMNS_REF_TYPE =  ObjectColumn.class;

		boolean COLUMNS_REF_MULTIPLE = true;

		/**
		 * PASSING Reference
		 */
		String PASSING_REF_NAME = Namespace.PREFIX + COLON + "passing";

		Class<?> PASSING_REF_TYPE =  DerivedColumn.class;

		boolean PASSING_REF_MULTIPLE = true;

	}

	/**
	 * tsql:textTable
	 */
	public interface TextTable extends TableFunctionReference {

		String ID = Namespace.PREFIX + COLON + "textTable";

		boolean IS_ABSTRACT = false;

		/**
		 * HEADER Property
		 */
		String HEADER_PROP_NAME = Namespace.PREFIX + COLON + "header";

		Class<?> HEADER_PROP_TYPE =  Long.class;

		boolean HEADER_PROP_MULTIPLE = false;

		/**
		 * USING_ROW_DELIMITER Property
		 */
		String USING_ROW_DELIMITER_PROP_NAME = Namespace.PREFIX + COLON + "usingRowDelimiter";

		Class<?> USING_ROW_DELIMITER_PROP_TYPE =  Boolean.class;

		boolean USING_ROW_DELIMITER_PROP_MULTIPLE = false;

		/**
		 * QUOTE Property
		 */
		String QUOTE_PROP_NAME = Namespace.PREFIX + COLON + "quote";

		Class<?> QUOTE_PROP_TYPE =  String.class;

		boolean QUOTE_PROP_MULTIPLE = false;

		/**
		 * SELECTOR Property
		 */
		String SELECTOR_PROP_NAME = Namespace.PREFIX + COLON + "selector";

		Class<?> SELECTOR_PROP_TYPE =  String.class;

		boolean SELECTOR_PROP_MULTIPLE = false;

		/**
		 * ESCAPE Property
		 */
		String ESCAPE_PROP_NAME = Namespace.PREFIX + COLON + "escape";

		Class<?> ESCAPE_PROP_TYPE =  Boolean.class;

		boolean ESCAPE_PROP_MULTIPLE = false;

		/**
		 * SKIP Property
		 */
		String SKIP_PROP_NAME = Namespace.PREFIX + COLON + "skip";

		Class<?> SKIP_PROP_TYPE =  Long.class;

		boolean SKIP_PROP_MULTIPLE = false;

		/**
		 * FIXED_WIDTH Property
		 */
		String FIXED_WIDTH_PROP_NAME = Namespace.PREFIX + COLON + "fixedWidth";

		Class<?> FIXED_WIDTH_PROP_TYPE =  Boolean.class;

		boolean FIXED_WIDTH_PROP_MULTIPLE = false;

		/**
		 * DELIMITER Property
		 */
		String DELIMITER_PROP_NAME = Namespace.PREFIX + COLON + "delimiter";

		Class<?> DELIMITER_PROP_TYPE =  String.class;

		boolean DELIMITER_PROP_MULTIPLE = false;

		/**
		 * COLUMNS Reference
		 */
		String COLUMNS_REF_NAME = Namespace.PREFIX + COLON + "columns";

		Class<?> COLUMNS_REF_TYPE =  TextColumn.class;

		boolean COLUMNS_REF_MULTIPLE = true;

		/**
		 * FILE Reference
		 */
		String FILE_REF_NAME = Namespace.PREFIX + COLON + "file";

		Class<?> FILE_REF_TYPE =  Expression.class;

		boolean FILE_REF_MULTIPLE = false;

	}

	/**
	 * tsql:xMLTable
	 */
	public interface XMLTable extends TableFunctionReference {

		String ID = Namespace.PREFIX + COLON + "xMLTable";

		boolean IS_ABSTRACT = false;

		/**
		 * USING_DEFAULT_COLUMN Property
		 */
		String USING_DEFAULT_COLUMN_PROP_NAME = Namespace.PREFIX + COLON + "usingDefaultColumn";

		Class<?> USING_DEFAULT_COLUMN_PROP_TYPE =  Boolean.class;

		boolean USING_DEFAULT_COLUMN_PROP_MULTIPLE = false;

		/**
		 * XQUERY Property
		 */
		String XQUERY_PROP_NAME = Namespace.PREFIX + COLON + "xquery";

		Class<?> XQUERY_PROP_TYPE =  String.class;

		boolean XQUERY_PROP_MULTIPLE = false;

		/**
		 * COLUMNS Reference
		 */
		String COLUMNS_REF_NAME = Namespace.PREFIX + COLON + "columns";

		Class<?> COLUMNS_REF_TYPE =  XMLColumn.class;

		boolean COLUMNS_REF_MULTIPLE = true;

		/**
		 * PASSING Reference
		 */
		String PASSING_REF_NAME = Namespace.PREFIX + COLON + "passing";

		Class<?> PASSING_REF_TYPE =  DerivedColumn.class;

		boolean PASSING_REF_MULTIPLE = true;

		/**
		 * NAMESPACES Reference
		 */
		String NAMESPACES_REF_NAME = Namespace.PREFIX + COLON + "namespaces";

		Class<?> NAMESPACES_REF_TYPE =  XMLNamespaces.class;

		boolean NAMESPACES_REF_MULTIPLE = false;

	}

	/**
	 * tsql:joinPredicate
	 */
	public interface JoinPredicate extends FromClause {

		String ID = Namespace.PREFIX + COLON + "joinPredicate";

		boolean IS_ABSTRACT = false;

		/**
		 * LEFT_CLAUSE Reference
		 */
		String LEFT_CLAUSE_REF_NAME = Namespace.PREFIX + COLON + "leftClause";

		Class<?> LEFT_CLAUSE_REF_TYPE =  FromClause.class;

		boolean LEFT_CLAUSE_REF_MULTIPLE = false;

		/**
		 * RIGHT_CLAUSE Reference
		 */
		String RIGHT_CLAUSE_REF_NAME = Namespace.PREFIX + COLON + "rightClause";

		Class<?> RIGHT_CLAUSE_REF_TYPE =  FromClause.class;

		boolean RIGHT_CLAUSE_REF_MULTIPLE = false;

		/**
		 * JOIN_CRITERIA Reference
		 */
		String JOIN_CRITERIA_REF_NAME = Namespace.PREFIX + COLON + "joinCriteria";

		Class<?> JOIN_CRITERIA_REF_TYPE =  Criteria.class;

		boolean JOIN_CRITERIA_REF_MULTIPLE = true;

		/**
		 * JOIN_TYPE Reference
		 */
		String JOIN_TYPE_REF_NAME = Namespace.PREFIX + COLON + "joinType";

		Class<?> JOIN_TYPE_REF_TYPE =  JoinType.class;

		boolean JOIN_TYPE_REF_MULTIPLE = false;

	}

	/**
	 * tsql:subqueryFromClause
	 */
	public interface SubqueryFromClause extends FromClause, SubqueryContainer {

		String ID = Namespace.PREFIX + COLON + "subqueryFromClause";

		boolean IS_ABSTRACT = false;

		/**
		 * TABLE Property
		 */
		String TABLE_PROP_NAME = Namespace.PREFIX + COLON + "table";

		Class<?> TABLE_PROP_TYPE =  Boolean.class;

		boolean TABLE_PROP_MULTIPLE = false;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  Command.class;

		boolean COMMAND_REF_MULTIPLE = false;

	}

	/**
	 * tsql:unaryFromClause
	 */
	public interface UnaryFromClause extends FromClause {

		String ID = Namespace.PREFIX + COLON + "unaryFromClause";

		boolean IS_ABSTRACT = false;

		/**
		 * EXPANDED_COMMAND Reference
		 */
		String EXPANDED_COMMAND_REF_NAME = Namespace.PREFIX + COLON + "expandedCommand";

		Class<?> EXPANDED_COMMAND_REF_TYPE =  Command.class;

		boolean EXPANDED_COMMAND_REF_MULTIPLE = false;

		/**
		 * GROUP Reference
		 */
		String GROUP_REF_NAME = Namespace.PREFIX + COLON + "group";

		Class<?> GROUP_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:from
	 */
	public interface From extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "from";

		boolean IS_ABSTRACT = false;

		/**
		 * CLAUSES Reference
		 */
		String CLAUSES_REF_NAME = Namespace.PREFIX + COLON + "clauses";

		Class<?> CLAUSES_REF_TYPE =  FromClause.class;

		boolean CLAUSES_REF_MULTIPLE = true;

	}

	/**
	 * tsql:groupBy
	 */
	public interface GroupBy extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "groupBy";

		boolean IS_ABSTRACT = false;

		/**
		 * ROLLUP Property
		 */
		String ROLLUP_PROP_NAME = Namespace.PREFIX + COLON + "rollup";

		Class<?> ROLLUP_PROP_TYPE =  Boolean.class;

		boolean ROLLUP_PROP_MULTIPLE = false;

		/**
		 * SYMBOLS Reference
		 */
		String SYMBOLS_REF_NAME = Namespace.PREFIX + COLON + "symbols";

		Class<?> SYMBOLS_REF_TYPE =  Expression.class;

		boolean SYMBOLS_REF_MULTIPLE = true;

	}

	/**
	 * tsql:into
	 */
	public interface Into extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "into";

		boolean IS_ABSTRACT = false;

		/**
		 * GROUP Reference
		 */
		String GROUP_REF_NAME = Namespace.PREFIX + COLON + "group";

		Class<?> GROUP_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:joinType
	 */
	public interface JoinType extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "joinType";

		boolean IS_ABSTRACT = false;

	}

	/**
	 * tsql:limit
	 */
	public interface Limit extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "limit";

		boolean IS_ABSTRACT = false;

		/**
		 * STRICT Property
		 */
		String STRICT_PROP_NAME = Namespace.PREFIX + COLON + "strict";

		Class<?> STRICT_PROP_TYPE =  Boolean.class;

		boolean STRICT_PROP_MULTIPLE = false;

		/**
		 * IMPLICIT Property
		 */
		String IMPLICIT_PROP_NAME = Namespace.PREFIX + COLON + "implicit";

		Class<?> IMPLICIT_PROP_TYPE =  Boolean.class;

		boolean IMPLICIT_PROP_MULTIPLE = false;

		/**
		 * OFFSET Reference
		 */
		String OFFSET_REF_NAME = Namespace.PREFIX + COLON + "offset";

		Class<?> OFFSET_REF_TYPE =  Expression.class;

		boolean OFFSET_REF_MULTIPLE = false;

		/**
		 * ROW_LIMIT Reference
		 */
		String ROW_LIMIT_REF_NAME = Namespace.PREFIX + COLON + "rowLimit";

		Class<?> ROW_LIMIT_REF_TYPE =  Expression.class;

		boolean ROW_LIMIT_REF_MULTIPLE = false;

	}

	/**
	 * tsql:namespaceItem
	 */
	public interface NamespaceItem extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "namespaceItem";

		boolean IS_ABSTRACT = false;

		/**
		 * PREFIX Property
		 */
		String PREFIX_PROP_NAME = Namespace.PREFIX + COLON + "prefix";

		Class<?> PREFIX_PROP_TYPE =  String.class;

		boolean PREFIX_PROP_MULTIPLE = false;

		/**
		 * URI Property
		 */
		String URI_PROP_NAME = Namespace.PREFIX + COLON + "uri";

		Class<?> URI_PROP_TYPE =  String.class;

		boolean URI_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:projectedColumn
	 */
	public interface ProjectedColumn extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "projectedColumn";

		boolean IS_ABSTRACT = false;

		/**
		 * TYPE Property
		 */
		String TYPE_PROP_NAME = Namespace.PREFIX + COLON + "type";

		Class<?> TYPE_PROP_TYPE =  String.class;

		boolean TYPE_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:objectColumn
	 */
	public interface ObjectColumn extends ProjectedColumn {

		String ID = Namespace.PREFIX + COLON + "objectColumn";

		boolean IS_ABSTRACT = false;

		/**
		 * PATH Property
		 */
		String PATH_PROP_NAME = Namespace.PREFIX + COLON + "path";

		Class<?> PATH_PROP_TYPE =  String.class;

		boolean PATH_PROP_MULTIPLE = false;

		/**
		 * DEFAULT_EXPRESSION Reference
		 */
		String DEFAULT_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "defaultExpression";

		Class<?> DEFAULT_EXPRESSION_REF_TYPE =  Expression.class;

		boolean DEFAULT_EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:textColumn
	 */
	public interface TextColumn extends ProjectedColumn {

		String ID = Namespace.PREFIX + COLON + "textColumn";

		boolean IS_ABSTRACT = false;

		/**
		 * SELECTOR Property
		 */
		String SELECTOR_PROP_NAME = Namespace.PREFIX + COLON + "selector";

		Class<?> SELECTOR_PROP_TYPE =  String.class;

		boolean SELECTOR_PROP_MULTIPLE = false;

		/**
		 * ORDINAL Property
		 */
		String ORDINAL_PROP_NAME = Namespace.PREFIX + COLON + "ordinal";

		Class<?> ORDINAL_PROP_TYPE =  Boolean.class;

		boolean ORDINAL_PROP_MULTIPLE = false;

		/**
		 * POSITION Property
		 */
		String POSITION_PROP_NAME = Namespace.PREFIX + COLON + "position";

		Class<?> POSITION_PROP_TYPE =  Long.class;

		boolean POSITION_PROP_MULTIPLE = false;

		/**
		 * NAME Property
		 */
		String NAME_PROP_NAME = Namespace.PREFIX + COLON + "name";

		Class<?> NAME_PROP_TYPE =  String.class;

		boolean NAME_PROP_MULTIPLE = false;

		/**
		 * NO_TRIM Property
		 */
		String NO_TRIM_PROP_NAME = Namespace.PREFIX + COLON + "noTrim";

		Class<?> NO_TRIM_PROP_TYPE =  Boolean.class;

		boolean NO_TRIM_PROP_MULTIPLE = false;

		/**
		 * WIDTH Property
		 */
		String WIDTH_PROP_NAME = Namespace.PREFIX + COLON + "width";

		Class<?> WIDTH_PROP_TYPE =  Long.class;

		boolean WIDTH_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:xMLColumn
	 */
	public interface XMLColumn extends ProjectedColumn {

		String ID = Namespace.PREFIX + COLON + "xMLColumn";

		boolean IS_ABSTRACT = false;

		/**
		 * ORDINAL Property
		 */
		String ORDINAL_PROP_NAME = Namespace.PREFIX + COLON + "ordinal";

		Class<?> ORDINAL_PROP_TYPE =  Boolean.class;

		boolean ORDINAL_PROP_MULTIPLE = false;

		/**
		 * PATH Property
		 */
		String PATH_PROP_NAME = Namespace.PREFIX + COLON + "path";

		Class<?> PATH_PROP_TYPE =  String.class;

		boolean PATH_PROP_MULTIPLE = false;

		/**
		 * NAME Property
		 */
		String NAME_PROP_NAME = Namespace.PREFIX + COLON + "name";

		Class<?> NAME_PROP_TYPE =  String.class;

		boolean NAME_PROP_MULTIPLE = false;

		/**
		 * DEFAULT_EXPRESSION Reference
		 */
		String DEFAULT_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "defaultExpression";

		Class<?> DEFAULT_EXPRESSION_REF_TYPE =  Expression.class;

		boolean DEFAULT_EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:option
	 */
	public interface Option extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "option";

		boolean IS_ABSTRACT = false;

		/**
		 * NO_CACHE Property
		 */
		String NO_CACHE_PROP_NAME = Namespace.PREFIX + COLON + "noCache";

		Class<?> NO_CACHE_PROP_TYPE =  Boolean.class;

		boolean NO_CACHE_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:orderBy
	 */
	public interface OrderBy extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "orderBy";

		boolean IS_ABSTRACT = false;

	}

	/**
	 * tsql:orderByItem
	 */
	public interface OrderByItem extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "orderByItem";

		boolean IS_ABSTRACT = false;

		/**
		 * NULL_ORDERING Property
		 */
		String NULL_ORDERING_PROP_NAME = Namespace.PREFIX + COLON + "nullOrdering";

		Class<?> NULL_ORDERING_PROP_TYPE =  String.class;

		boolean NULL_ORDERING_PROP_MULTIPLE = false;

		String[] NULL_ORDERING_PROP_CONSTRAINTS = { "FIRST", "LAST" };

		/**
		 * ASCENDING Property
		 */
		String ASCENDING_PROP_NAME = Namespace.PREFIX + COLON + "ascending";

		Class<?> ASCENDING_PROP_TYPE =  Boolean.class;

		boolean ASCENDING_PROP_MULTIPLE = false;

		/**
		 * SYMBOL Reference
		 */
		String SYMBOL_REF_NAME = Namespace.PREFIX + COLON + "symbol";

		Class<?> SYMBOL_REF_TYPE =  Expression.class;

		boolean SYMBOL_REF_MULTIPLE = false;

	}

	/**
	 * tsql:sPParameter
	 */
	public interface SPParameter extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "sPParameter";

		boolean IS_ABSTRACT = false;

		/**
		 * CLASS_TYPE_CLASS Property
		 */
		String CLASS_TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "classTypeClass";

		Class<?> CLASS_TYPE_CLASS_PROP_TYPE =  String.class;

		boolean CLASS_TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * METADATAID Property
		 */
		String METADATAID_PROP_NAME = Namespace.PREFIX + COLON + "metadataID";

		Class<?> METADATAID_PROP_TYPE =  Object.class;

		boolean METADATAID_PROP_MULTIPLE = false;

		/**
		 * USING_DEFAULT Property
		 */
		String USING_DEFAULT_PROP_NAME = Namespace.PREFIX + COLON + "usingDefault";

		Class<?> USING_DEFAULT_PROP_TYPE =  Boolean.class;

		boolean USING_DEFAULT_PROP_MULTIPLE = false;

		/**
		 * VAR_ARG Property
		 */
		String VAR_ARG_PROP_NAME = Namespace.PREFIX + COLON + "varArg";

		Class<?> VAR_ARG_PROP_TYPE =  Boolean.class;

		boolean VAR_ARG_PROP_MULTIPLE = false;

		/**
		 * NAME Property
		 */
		String NAME_PROP_NAME = Namespace.PREFIX + COLON + "name";

		Class<?> NAME_PROP_TYPE =  String.class;

		boolean NAME_PROP_MULTIPLE = false;

		/**
		 * INDEX Property
		 */
		String INDEX_PROP_NAME = Namespace.PREFIX + COLON + "index";

		Class<?> INDEX_PROP_TYPE =  Long.class;

		boolean INDEX_PROP_MULTIPLE = false;

		/**
		 * PARAMETER_TYPE Property
		 */
		String PARAMETER_TYPE_PROP_NAME = Namespace.PREFIX + COLON + "parameterType";

		Class<?> PARAMETER_TYPE_PROP_TYPE =  Long.class;

		boolean PARAMETER_TYPE_PROP_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:select
	 */
	public interface Select extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "select";

		boolean IS_ABSTRACT = false;

		/**
		 * DISTINCT Property
		 */
		String DISTINCT_PROP_NAME = Namespace.PREFIX + COLON + "distinct";

		Class<?> DISTINCT_PROP_TYPE =  Boolean.class;

		boolean DISTINCT_PROP_MULTIPLE = false;

		/**
		 * SYMBOLS Reference
		 */
		String SYMBOLS_REF_NAME = Namespace.PREFIX + COLON + "symbols";

		Class<?> SYMBOLS_REF_TYPE =  Expression.class;

		boolean SYMBOLS_REF_MULTIPLE = true;

	}

	/**
	 * tsql:setClause
	 */
	public interface SetClause extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "setClause";

		boolean IS_ABSTRACT = false;

		/**
		 * VALUE Reference
		 */
		String VALUE_REF_NAME = Namespace.PREFIX + COLON + "value";

		Class<?> VALUE_REF_TYPE =  Expression.class;

		boolean VALUE_REF_MULTIPLE = false;

		/**
		 * SYMBOL Reference
		 */
		String SYMBOL_REF_NAME = Namespace.PREFIX + COLON + "symbol";

		Class<?> SYMBOL_REF_TYPE =  ElementSymbol.class;

		boolean SYMBOL_REF_MULTIPLE = false;

	}

	/**
	 * tsql:setClauseList
	 */
	public interface SetClauseList extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "setClauseList";

		boolean IS_ABSTRACT = false;

	}

	/**
	 * tsql:sourceHint
	 */
	public interface SourceHint extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "sourceHint";

		boolean IS_ABSTRACT = false;

		/**
		 * USE_ALIASES Property
		 */
		String USE_ALIASES_PROP_NAME = Namespace.PREFIX + COLON + "useAliases";

		Class<?> USE_ALIASES_PROP_TYPE =  Boolean.class;

		boolean USE_ALIASES_PROP_MULTIPLE = false;

		/**
		 * GENERAL_HINT Property
		 */
		String GENERAL_HINT_PROP_NAME = Namespace.PREFIX + COLON + "generalHint";

		Class<?> GENERAL_HINT_PROP_TYPE =  String.class;

		boolean GENERAL_HINT_PROP_MULTIPLE = false;

		/**
		 * SOURCE_HINT Reference
		 */
		String SOURCE_HINT_REF_NAME = Namespace.PREFIX + COLON + "sourceHint";

		Class<?> SOURCE_HINT_REF_TYPE =  SpecificHint.class;

		boolean SOURCE_HINT_REF_MULTIPLE = false;

	}

	/**
	 * tsql:specificHint
	 */
	public interface SpecificHint extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "specificHint";

		boolean IS_ABSTRACT = false;

		/**
		 * TRANSLATOR_NAME Property
		 */
		String TRANSLATOR_NAME_PROP_NAME = Namespace.PREFIX + COLON + "translatorName";

		Class<?> TRANSLATOR_NAME_PROP_TYPE =  String.class;

		boolean TRANSLATOR_NAME_PROP_MULTIPLE = false;

		/**
		 * USE_ALIASES Property
		 */
		String USE_ALIASES_PROP_NAME = Namespace.PREFIX + COLON + "useAliases";

		Class<?> USE_ALIASES_PROP_TYPE =  Boolean.class;

		boolean USE_ALIASES_PROP_MULTIPLE = false;

		/**
		 * HINT Property
		 */
		String HINT_PROP_NAME = Namespace.PREFIX + COLON + "hint";

		Class<?> HINT_PROP_TYPE =  String.class;

		boolean HINT_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:subqueryHint
	 */
	public interface SubqueryHint extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "subqueryHint";

		boolean IS_ABSTRACT = false;

		/**
		 * MERGE_JOIN Property
		 */
		String MERGE_JOIN_PROP_NAME = Namespace.PREFIX + COLON + "mergeJoin";

		Class<?> MERGE_JOIN_PROP_TYPE =  Boolean.class;

		boolean MERGE_JOIN_PROP_MULTIPLE = false;

		/**
		 * DEP_JOIN Property
		 */
		String DEP_JOIN_PROP_NAME = Namespace.PREFIX + COLON + "depJoin";

		Class<?> DEP_JOIN_PROP_TYPE =  Boolean.class;

		boolean DEP_JOIN_PROP_MULTIPLE = false;

		/**
		 * NO_UNNEST Property
		 */
		String NO_UNNEST_PROP_NAME = Namespace.PREFIX + COLON + "noUnnest";

		Class<?> NO_UNNEST_PROP_TYPE =  Boolean.class;

		boolean NO_UNNEST_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:withQueryCommand
	 */
	public interface WithQueryCommand extends SubqueryContainer {

		String ID = Namespace.PREFIX + COLON + "withQueryCommand";

		boolean IS_ABSTRACT = false;

		/**
		 * COLUMNS Reference
		 */
		String COLUMNS_REF_NAME = Namespace.PREFIX + COLON + "columns";

		Class<?> COLUMNS_REF_TYPE =  ElementSymbol.class;

		boolean COLUMNS_REF_MULTIPLE = true;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  QueryCommand.class;

		boolean COMMAND_REF_MULTIPLE = false;

		/**
		 * QUERY_EXPRESSION Reference
		 */
		String QUERY_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "queryExpression";

		Class<?> QUERY_EXPRESSION_REF_TYPE =  QueryCommand.class;

		boolean QUERY_EXPRESSION_REF_MULTIPLE = false;

		/**
		 * GROUP_SYMBOL Reference
		 */
		String GROUP_SYMBOL_REF_NAME = Namespace.PREFIX + COLON + "groupSymbol";

		Class<?> GROUP_SYMBOL_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_SYMBOL_REF_MULTIPLE = false;

	}

	/**
	 * tsql:statement
	 */
	public interface Statement extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "statement";

		boolean IS_ABSTRACT = true;

	}

	/**
	 * tsql:assignmentStatement
	 */
	public interface AssignmentStatement extends Statement, ExpressionStatement {

		String ID = Namespace.PREFIX + COLON + "assignmentStatement";

		boolean IS_ABSTRACT = false;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  Command.class;

		boolean COMMAND_REF_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

		/**
		 * VARIABLE Reference
		 */
		String VARIABLE_REF_NAME = Namespace.PREFIX + COLON + "variable";

		Class<?> VARIABLE_REF_TYPE =  ElementSymbol.class;

		boolean VARIABLE_REF_MULTIPLE = false;

		/**
		 * VALUE Reference
		 */
		String VALUE_REF_NAME = Namespace.PREFIX + COLON + "value";

		Class<?> VALUE_REF_TYPE =  Expression.class;

		boolean VALUE_REF_MULTIPLE = false;

	}

	/**
	 * tsql:declareStatement
	 */
	public interface DeclareStatement extends AssignmentStatement {

		String ID = Namespace.PREFIX + COLON + "declareStatement";

		boolean IS_ABSTRACT = false;

		/**
		 * VARIABLE_TYPE Property
		 */
		String VARIABLE_TYPE_PROP_NAME = Namespace.PREFIX + COLON + "variableType";

		Class<?> VARIABLE_TYPE_PROP_TYPE =  String.class;

		boolean VARIABLE_TYPE_PROP_MULTIPLE = false;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  Command.class;

		boolean COMMAND_REF_MULTIPLE = false;

		/**
		 * VARIABLE Reference
		 */
		String VARIABLE_REF_NAME = Namespace.PREFIX + COLON + "variable";

		Class<?> VARIABLE_REF_TYPE =  ElementSymbol.class;

		boolean VARIABLE_REF_MULTIPLE = false;

	}

	/**
	 * tsql:returnStatement
	 */
	public interface ReturnStatement extends AssignmentStatement {

		String ID = Namespace.PREFIX + COLON + "returnStatement";

		boolean IS_ABSTRACT = false;

	}

	/**
	 * tsql:block
	 */
	public interface Block extends Statement, Labeled {

		String ID = Namespace.PREFIX + COLON + "block";

		boolean IS_ABSTRACT = false;

		/**
		 * ATOMIC Property
		 */
		String ATOMIC_PROP_NAME = Namespace.PREFIX + COLON + "atomic";

		Class<?> ATOMIC_PROP_TYPE =  Boolean.class;

		boolean ATOMIC_PROP_MULTIPLE = false;

		/**
		 * EXCEPTION_GROUP Property
		 */
		String EXCEPTION_GROUP_PROP_NAME = Namespace.PREFIX + COLON + "exceptionGroup";

		Class<?> EXCEPTION_GROUP_PROP_TYPE =  String.class;

		boolean EXCEPTION_GROUP_PROP_MULTIPLE = false;

		/**
		 * LABEL Property
		 */
		String LABEL_PROP_NAME = Namespace.PREFIX + COLON + "label";

		Class<?> LABEL_PROP_TYPE =  String.class;

		boolean LABEL_PROP_MULTIPLE = false;

		/**
		 * EXCEPTION_STATEMENTS Reference
		 */
		String EXCEPTION_STATEMENTS_REF_NAME = Namespace.PREFIX + COLON + "exceptionStatements";

		Class<?> EXCEPTION_STATEMENTS_REF_TYPE =  Statement.class;

		boolean EXCEPTION_STATEMENTS_REF_MULTIPLE = true;

	}

	/**
	 * tsql:branchingStatement
	 */
	public interface BranchingStatement extends Statement {

		String ID = Namespace.PREFIX + COLON + "branchingStatement";

		boolean IS_ABSTRACT = false;

		/**
		 * LABEL Property
		 */
		String LABEL_PROP_NAME = Namespace.PREFIX + COLON + "label";

		Class<?> LABEL_PROP_TYPE =  String.class;

		boolean LABEL_PROP_MULTIPLE = false;

		/**
		 * MODE Property
		 */
		String MODE_PROP_NAME = Namespace.PREFIX + COLON + "mode";

		Class<?> MODE_PROP_TYPE =  String.class;

		boolean MODE_PROP_MULTIPLE = false;

		String[] MODE_PROP_CONSTRAINTS = { "BREAK", "CONTINUE", "LEAVE" };

	}

	/**
	 * tsql:commandStatement
	 */
	public interface CommandStatement extends Statement, SubqueryContainer {

		String ID = Namespace.PREFIX + COLON + "commandStatement";

		boolean IS_ABSTRACT = false;

		/**
		 * RETURNABLE Property
		 */
		String RETURNABLE_PROP_NAME = Namespace.PREFIX + COLON + "returnable";

		Class<?> RETURNABLE_PROP_TYPE =  Boolean.class;

		boolean RETURNABLE_PROP_MULTIPLE = false;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  Command.class;

		boolean COMMAND_REF_MULTIPLE = false;

	}

	/**
	 * tsql:ifStatement
	 */
	public interface IfStatement extends Statement {

		String ID = Namespace.PREFIX + COLON + "ifStatement";

		boolean IS_ABSTRACT = false;

		/**
		 * CONDITION Reference
		 */
		String CONDITION_REF_NAME = Namespace.PREFIX + COLON + "condition";

		Class<?> CONDITION_REF_TYPE =  Criteria.class;

		boolean CONDITION_REF_MULTIPLE = false;

		/**
		 * ELSE_BLOCK Reference
		 */
		String ELSE_BLOCK_REF_NAME = Namespace.PREFIX + COLON + "elseBlock";

		Class<?> ELSE_BLOCK_REF_TYPE =  Block.class;

		boolean ELSE_BLOCK_REF_MULTIPLE = false;

		/**
		 * IF_BLOCK Reference
		 */
		String IF_BLOCK_REF_NAME = Namespace.PREFIX + COLON + "ifBlock";

		Class<?> IF_BLOCK_REF_TYPE =  Block.class;

		boolean IF_BLOCK_REF_MULTIPLE = false;

	}

	/**
	 * tsql:loopStatement
	 */
	public interface LoopStatement extends Statement, Labeled, SubqueryContainer {

		String ID = Namespace.PREFIX + COLON + "loopStatement";

		boolean IS_ABSTRACT = false;

		/**
		 * CURSOR_NAME Property
		 */
		String CURSOR_NAME_PROP_NAME = Namespace.PREFIX + COLON + "cursorName";

		Class<?> CURSOR_NAME_PROP_TYPE =  String.class;

		boolean CURSOR_NAME_PROP_MULTIPLE = false;

		/**
		 * LABEL Property
		 */
		String LABEL_PROP_NAME = Namespace.PREFIX + COLON + "label";

		Class<?> LABEL_PROP_TYPE =  String.class;

		boolean LABEL_PROP_MULTIPLE = false;

		/**
		 * BLOCK Reference
		 */
		String BLOCK_REF_NAME = Namespace.PREFIX + COLON + "block";

		Class<?> BLOCK_REF_TYPE =  Block.class;

		boolean BLOCK_REF_MULTIPLE = false;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  Command.class;

		boolean COMMAND_REF_MULTIPLE = false;

	}

	/**
	 * tsql:raiseStatement
	 */
	public interface RaiseStatement extends Statement, ExpressionStatement {

		String ID = Namespace.PREFIX + COLON + "raiseStatement";

		boolean IS_ABSTRACT = false;

		/**
		 * WARNING Property
		 */
		String WARNING_PROP_NAME = Namespace.PREFIX + COLON + "warning";

		Class<?> WARNING_PROP_TYPE =  Boolean.class;

		boolean WARNING_PROP_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:whileStatement
	 */
	public interface WhileStatement extends Statement, Labeled {

		String ID = Namespace.PREFIX + COLON + "whileStatement";

		boolean IS_ABSTRACT = false;

		/**
		 * LABEL Property
		 */
		String LABEL_PROP_NAME = Namespace.PREFIX + COLON + "label";

		Class<?> LABEL_PROP_TYPE =  String.class;

		boolean LABEL_PROP_MULTIPLE = false;

		/**
		 * BLOCK Reference
		 */
		String BLOCK_REF_NAME = Namespace.PREFIX + COLON + "block";

		Class<?> BLOCK_REF_TYPE =  Block.class;

		boolean BLOCK_REF_MULTIPLE = false;

		/**
		 * CONDITION Reference
		 */
		String CONDITION_REF_NAME = Namespace.PREFIX + COLON + "condition";

		Class<?> CONDITION_REF_TYPE =  Criteria.class;

		boolean CONDITION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:exceptionExpression
	 */
	public interface ExceptionExpression extends Expression {

		String ID = Namespace.PREFIX + COLON + "exceptionExpression";

		boolean IS_ABSTRACT = false;

		/**
		 * ERROR_CODE Reference
		 */
		String ERROR_CODE_REF_NAME = Namespace.PREFIX + COLON + "errorCode";

		Class<?> ERROR_CODE_REF_TYPE =  Expression.class;

		boolean ERROR_CODE_REF_MULTIPLE = false;

		/**
		 * MESSAGE Reference
		 */
		String MESSAGE_REF_NAME = Namespace.PREFIX + COLON + "message";

		Class<?> MESSAGE_REF_TYPE =  Expression.class;

		boolean MESSAGE_REF_MULTIPLE = false;

		/**
		 * PARENT_EXPRESSION Reference
		 */
		String PARENT_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "parentExpression";

		Class<?> PARENT_EXPRESSION_REF_TYPE =  Expression.class;

		boolean PARENT_EXPRESSION_REF_MULTIPLE = false;

		/**
		 * SQL_STATE Reference
		 */
		String SQL_STATE_REF_NAME = Namespace.PREFIX + COLON + "sqlState";

		Class<?> SQL_STATE_REF_TYPE =  Expression.class;

		boolean SQL_STATE_REF_MULTIPLE = false;

	}

	/**
	 * tsql:function
	 */
	public interface Function extends Expression {

		String ID = Namespace.PREFIX + COLON + "function";

		boolean IS_ABSTRACT = false;

		/**
		 * TYPE_CLASS Property
		 */
		String TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "typeClass";

		Class<?> TYPE_CLASS_PROP_TYPE =  String.class;

		boolean TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * ARGS Reference
		 */
		String ARGS_REF_NAME = Namespace.PREFIX + COLON + "args";

		Class<?> ARGS_REF_TYPE =  Expression.class;

		boolean ARGS_REF_MULTIPLE = true;

	}

	/**
	 * tsql:aggregateSymbol
	 */
	public interface AggregateSymbol extends Function {

		String ID = Namespace.PREFIX + COLON + "aggregateSymbol";

		boolean IS_ABSTRACT = false;

		/**
		 * WINDOWED Property
		 */
		String WINDOWED_PROP_NAME = Namespace.PREFIX + COLON + "windowed";

		Class<?> WINDOWED_PROP_TYPE =  Boolean.class;

		boolean WINDOWED_PROP_MULTIPLE = false;

		/**
		 * TYPE_CLASS Property
		 */
		String TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "typeClass";

		Class<?> TYPE_CLASS_PROP_TYPE =  String.class;

		boolean TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * AGGREGATE_FUNCTION Property
		 */
		String AGGREGATE_FUNCTION_PROP_NAME = Namespace.PREFIX + COLON + "aggregateFunction";

		Class<?> AGGREGATE_FUNCTION_PROP_TYPE =  String.class;

		boolean AGGREGATE_FUNCTION_PROP_MULTIPLE = false;

		/**
		 * DISTINCT Property
		 */
		String DISTINCT_PROP_NAME = Namespace.PREFIX + COLON + "distinct";

		Class<?> DISTINCT_PROP_TYPE =  Boolean.class;

		boolean DISTINCT_PROP_MULTIPLE = false;

		/**
		 * IMPLICIT Property
		 */
		String IMPLICIT_PROP_NAME = Namespace.PREFIX + COLON + "implicit";

		Class<?> IMPLICIT_PROP_TYPE =  Boolean.class;

		boolean IMPLICIT_PROP_MULTIPLE = false;

		/**
		 * ORDER_BY Reference
		 */
		String ORDER_BY_REF_NAME = Namespace.PREFIX + COLON + "orderBy";

		Class<?> ORDER_BY_REF_TYPE =  OrderBy.class;

		boolean ORDER_BY_REF_MULTIPLE = false;

		/**
		 * ARGS Reference
		 */
		String ARGS_REF_NAME = Namespace.PREFIX + COLON + "args";

		Class<?> ARGS_REF_TYPE =  Expression.class;

		boolean ARGS_REF_MULTIPLE = true;

		/**
		 * CONDITION Reference
		 */
		String CONDITION_REF_NAME = Namespace.PREFIX + COLON + "condition";

		Class<?> CONDITION_REF_TYPE =  Expression.class;

		boolean CONDITION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:symbol
	 */
	public interface Symbol extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "symbol";

		boolean IS_ABSTRACT = false;

		/**
		 * SHORT_NAME Property
		 */
		String SHORT_NAME_PROP_NAME = Namespace.PREFIX + COLON + "shortName";

		Class<?> SHORT_NAME_PROP_TYPE =  String.class;

		boolean SHORT_NAME_PROP_MULTIPLE = false;

		/**
		 * NAME Property
		 */
		String NAME_PROP_NAME = Namespace.PREFIX + COLON + "name";

		Class<?> NAME_PROP_TYPE =  String.class;

		boolean NAME_PROP_MULTIPLE = false;

		/**
		 * OUTPUT_NAME Property
		 */
		String OUTPUT_NAME_PROP_NAME = Namespace.PREFIX + COLON + "outputName";

		Class<?> OUTPUT_NAME_PROP_TYPE =  String.class;

		boolean OUTPUT_NAME_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:aliasSymbol
	 */
	public interface AliasSymbol extends Symbol, Expression {

		String ID = Namespace.PREFIX + COLON + "aliasSymbol";

		boolean IS_ABSTRACT = false;

		/**
		 * SYMBOL Reference
		 */
		String SYMBOL_REF_NAME = Namespace.PREFIX + COLON + "symbol";

		Class<?> SYMBOL_REF_TYPE =  Expression.class;

		boolean SYMBOL_REF_MULTIPLE = false;

	}

	/**
	 * tsql:elementSymbol
	 */
	public interface ElementSymbol extends Symbol, Expression {

		String ID = Namespace.PREFIX + COLON + "elementSymbol";

		boolean IS_ABSTRACT = false;

		/**
		 * METADATAID Property
		 */
		String METADATAID_PROP_NAME = Namespace.PREFIX + COLON + "metadataID";

		Class<?> METADATAID_PROP_TYPE =  Object.class;

		boolean METADATAID_PROP_MULTIPLE = false;

		/**
		 * TYPE_CLASS Property
		 */
		String TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "typeClass";

		Class<?> TYPE_CLASS_PROP_TYPE =  String.class;

		boolean TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * DISPLAY_FULLY_QUALIFIED Property
		 */
		String DISPLAY_FULLY_QUALIFIED_PROP_NAME = Namespace.PREFIX + COLON + "displayFullyQualified";

		Class<?> DISPLAY_FULLY_QUALIFIED_PROP_TYPE =  Boolean.class;

		boolean DISPLAY_FULLY_QUALIFIED_PROP_MULTIPLE = false;

		/**
		 * GROUP_SYMBOL Reference
		 */
		String GROUP_SYMBOL_REF_NAME = Namespace.PREFIX + COLON + "groupSymbol";

		Class<?> GROUP_SYMBOL_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_SYMBOL_REF_MULTIPLE = false;

	}

	/**
	 * tsql:expressionSymbol
	 */
	public interface ExpressionSymbol extends Symbol, Expression {

		String ID = Namespace.PREFIX + COLON + "expressionSymbol";

		boolean IS_ABSTRACT = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:groupSymbol
	 */
	public interface GroupSymbol extends Symbol {

		String ID = Namespace.PREFIX + COLON + "groupSymbol";

		boolean IS_ABSTRACT = false;

		/**
		 * METADATAID Property
		 */
		String METADATAID_PROP_NAME = Namespace.PREFIX + COLON + "metadataID";

		Class<?> METADATAID_PROP_TYPE =  Object.class;

		boolean METADATAID_PROP_MULTIPLE = false;

		/**
		 * DEFINITION Property
		 */
		String DEFINITION_PROP_NAME = Namespace.PREFIX + COLON + "definition";

		Class<?> DEFINITION_PROP_TYPE =  String.class;

		boolean DEFINITION_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:array
	 */
	public interface Array extends Expression {

		String ID = Namespace.PREFIX + COLON + "array";

		boolean IS_ABSTRACT = false;

		/**
		 * IMPLICIT Property
		 */
		String IMPLICIT_PROP_NAME = Namespace.PREFIX + COLON + "implicit";

		Class<?> IMPLICIT_PROP_TYPE =  Boolean.class;

		boolean IMPLICIT_PROP_MULTIPLE = false;

		/**
		 * EXPRESSIONS Reference
		 */
		String EXPRESSIONS_REF_NAME = Namespace.PREFIX + COLON + "expressions";

		Class<?> EXPRESSIONS_REF_TYPE =  Expression.class;

		boolean EXPRESSIONS_REF_MULTIPLE = true;

	}

	/**
	 * tsql:caseExpression
	 */
	public interface CaseExpression extends Expression {

		String ID = Namespace.PREFIX + COLON + "caseExpression";

		boolean IS_ABSTRACT = false;

		/**
		 * TYPE_CLASS Property
		 */
		String TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "typeClass";

		Class<?> TYPE_CLASS_PROP_TYPE =  String.class;

		boolean TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * ELSE_EXPRESSION Reference
		 */
		String ELSE_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "elseExpression";

		Class<?> ELSE_EXPRESSION_REF_TYPE =  Expression.class;

		boolean ELSE_EXPRESSION_REF_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

		/**
		 * WHEN Reference
		 */
		String WHEN_REF_NAME = Namespace.PREFIX + COLON + "when";

		Class<?> WHEN_REF_TYPE =  Expression.class;

		boolean WHEN_REF_MULTIPLE = true;

		/**
		 * THEN Reference
		 */
		String THEN_REF_NAME = Namespace.PREFIX + COLON + "then";

		Class<?> THEN_REF_TYPE =  Expression.class;

		boolean THEN_REF_MULTIPLE = true;

	}

	/**
	 * tsql:constant
	 */
	public interface Constant extends Expression {

		String ID = Namespace.PREFIX + COLON + "constant";

		boolean IS_ABSTRACT = false;

		/**
		 * TYPE_CLASS Property
		 */
		String TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "typeClass";

		Class<?> TYPE_CLASS_PROP_TYPE =  String.class;

		boolean TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * VALUE Property
		 */
		String VALUE_PROP_NAME = Namespace.PREFIX + COLON + "value";

		Class<?> VALUE_PROP_TYPE =  Object.class;

		boolean VALUE_PROP_MULTIPLE = false;

		/**
		 * MULTI_VALUED Property
		 */
		String MULTI_VALUED_PROP_NAME = Namespace.PREFIX + COLON + "multiValued";

		Class<?> MULTI_VALUED_PROP_TYPE =  Boolean.class;

		boolean MULTI_VALUED_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:derivedColumn
	 */
	public interface DerivedColumn extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "derivedColumn";

		boolean IS_ABSTRACT = false;

		/**
		 * ALIAS Property
		 */
		String ALIAS_PROP_NAME = Namespace.PREFIX + COLON + "alias";

		Class<?> ALIAS_PROP_TYPE =  String.class;

		boolean ALIAS_PROP_MULTIPLE = false;

		/**
		 * PROPAGATE_NAME Property
		 */
		String PROPAGATE_NAME_PROP_NAME = Namespace.PREFIX + COLON + "propagateName";

		Class<?> PROPAGATE_NAME_PROP_TYPE =  Boolean.class;

		boolean PROPAGATE_NAME_PROP_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:jSONObject
	 */
	public interface JSONObject extends Expression {

		String ID = Namespace.PREFIX + COLON + "jSONObject";

		boolean IS_ABSTRACT = false;

		/**
		 * ARGS Reference
		 */
		String ARGS_REF_NAME = Namespace.PREFIX + COLON + "args";

		Class<?> ARGS_REF_TYPE =  DerivedColumn.class;

		boolean ARGS_REF_MULTIPLE = true;

	}

	/**
	 * tsql:multipleElementSymbol
	 */
	public interface MultipleElementSymbol extends Expression {

		String ID = Namespace.PREFIX + COLON + "multipleElementSymbol";

		boolean IS_ABSTRACT = false;

		/**
		 * ELEMENT_SYMBOLS Reference
		 */
		String ELEMENT_SYMBOLS_REF_NAME = Namespace.PREFIX + COLON + "elementSymbols";

		Class<?> ELEMENT_SYMBOLS_REF_TYPE =  ElementSymbol.class;

		boolean ELEMENT_SYMBOLS_REF_MULTIPLE = true;

		/**
		 * GROUP Reference
		 */
		String GROUP_REF_NAME = Namespace.PREFIX + COLON + "group";

		Class<?> GROUP_REF_TYPE =  GroupSymbol.class;

		boolean GROUP_REF_MULTIPLE = false;

	}

	/**
	 * tsql:queryString
	 */
	public interface QueryString extends Expression {

		String ID = Namespace.PREFIX + COLON + "queryString";

		boolean IS_ABSTRACT = false;

		/**
		 * ARGS Reference
		 */
		String ARGS_REF_NAME = Namespace.PREFIX + COLON + "args";

		Class<?> ARGS_REF_TYPE =  DerivedColumn.class;

		boolean ARGS_REF_MULTIPLE = true;

		/**
		 * PATH Reference
		 */
		String PATH_REF_NAME = Namespace.PREFIX + COLON + "path";

		Class<?> PATH_REF_TYPE =  Expression.class;

		boolean PATH_REF_MULTIPLE = false;

	}

	/**
	 * tsql:reference
	 */
	public interface Reference extends Expression {

		String ID = Namespace.PREFIX + COLON + "reference";

		boolean IS_ABSTRACT = false;

		/**
		 * POSITIONAL Property
		 */
		String POSITIONAL_PROP_NAME = Namespace.PREFIX + COLON + "positional";

		Class<?> POSITIONAL_PROP_TYPE =  Boolean.class;

		boolean POSITIONAL_PROP_MULTIPLE = false;

		/**
		 * TYPE_CLASS Property
		 */
		String TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "typeClass";

		Class<?> TYPE_CLASS_PROP_TYPE =  String.class;

		boolean TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * INDEX Property
		 */
		String INDEX_PROP_NAME = Namespace.PREFIX + COLON + "index";

		Class<?> INDEX_PROP_TYPE =  Long.class;

		boolean INDEX_PROP_MULTIPLE = false;

	}

	/**
	 * tsql:scalarSubquery
	 */
	public interface ScalarSubquery extends Expression, SubqueryContainer {

		String ID = Namespace.PREFIX + COLON + "scalarSubquery";

		boolean IS_ABSTRACT = false;

		/**
		 * TYPE_CLASS Property
		 */
		String TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "typeClass";

		Class<?> TYPE_CLASS_PROP_TYPE =  String.class;

		boolean TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * COMMAND Reference
		 */
		String COMMAND_REF_NAME = Namespace.PREFIX + COLON + "command";

		Class<?> COMMAND_REF_TYPE =  QueryCommand.class;

		boolean COMMAND_REF_MULTIPLE = false;

	}

	/**
	 * tsql:searchedCaseExpression
	 */
	public interface SearchedCaseExpression extends Expression {

		String ID = Namespace.PREFIX + COLON + "searchedCaseExpression";

		boolean IS_ABSTRACT = false;

		/**
		 * TYPE_CLASS Property
		 */
		String TYPE_CLASS_PROP_NAME = Namespace.PREFIX + COLON + "typeClass";

		Class<?> TYPE_CLASS_PROP_TYPE =  String.class;

		boolean TYPE_CLASS_PROP_MULTIPLE = false;

		/**
		 * ELSE_EXPRESSION Reference
		 */
		String ELSE_EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "elseExpression";

		Class<?> ELSE_EXPRESSION_REF_TYPE =  Expression.class;

		boolean ELSE_EXPRESSION_REF_MULTIPLE = false;

		/**
		 * WHEN Reference
		 */
		String WHEN_REF_NAME = Namespace.PREFIX + COLON + "when";

		Class<?> WHEN_REF_TYPE =  Criteria.class;

		boolean WHEN_REF_MULTIPLE = true;

		/**
		 * THEN Reference
		 */
		String THEN_REF_NAME = Namespace.PREFIX + COLON + "then";

		Class<?> THEN_REF_TYPE =  Expression.class;

		boolean THEN_REF_MULTIPLE = true;

	}

	/**
	 * tsql:textLine
	 */
	public interface TextLine extends Expression {

		String ID = Namespace.PREFIX + COLON + "textLine";

		boolean IS_ABSTRACT = false;

		/**
		 * QUOTE Property
		 */
		String QUOTE_PROP_NAME = Namespace.PREFIX + COLON + "quote";

		Class<?> QUOTE_PROP_TYPE =  String.class;

		boolean QUOTE_PROP_MULTIPLE = false;

		/**
		 * ENCODING Property
		 */
		String ENCODING_PROP_NAME = Namespace.PREFIX + COLON + "encoding";

		Class<?> ENCODING_PROP_TYPE =  String.class;

		boolean ENCODING_PROP_MULTIPLE = false;

		/**
		 * INCLUDE_HEADER Property
		 */
		String INCLUDE_HEADER_PROP_NAME = Namespace.PREFIX + COLON + "includeHeader";

		Class<?> INCLUDE_HEADER_PROP_TYPE =  Boolean.class;

		boolean INCLUDE_HEADER_PROP_MULTIPLE = false;

		/**
		 * DELIMITER Property
		 */
		String DELIMITER_PROP_NAME = Namespace.PREFIX + COLON + "delimiter";

		Class<?> DELIMITER_PROP_TYPE =  String.class;

		boolean DELIMITER_PROP_MULTIPLE = false;

		/**
		 * EXPRESSIONS Reference
		 */
		String EXPRESSIONS_REF_NAME = Namespace.PREFIX + COLON + "expressions";

		Class<?> EXPRESSIONS_REF_TYPE =  DerivedColumn.class;

		boolean EXPRESSIONS_REF_MULTIPLE = true;

	}

	/**
	 * tsql:windowFunction
	 */
	public interface WindowFunction extends Expression {

		String ID = Namespace.PREFIX + COLON + "windowFunction";

		boolean IS_ABSTRACT = false;

		/**
		 * WINDOW_SPECIFICATION Reference
		 */
		String WINDOW_SPECIFICATION_REF_NAME = Namespace.PREFIX + COLON + "windowSpecification";

		Class<?> WINDOW_SPECIFICATION_REF_TYPE =  WindowSpecification.class;

		boolean WINDOW_SPECIFICATION_REF_MULTIPLE = false;

		/**
		 * FUNCTION Reference
		 */
		String FUNCTION_REF_NAME = Namespace.PREFIX + COLON + "function";

		Class<?> FUNCTION_REF_TYPE =  AggregateSymbol.class;

		boolean FUNCTION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:windowSpecification
	 */
	public interface WindowSpecification extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "windowSpecification";

		boolean IS_ABSTRACT = false;

		/**
		 * PARTITION Reference
		 */
		String PARTITION_REF_NAME = Namespace.PREFIX + COLON + "partition";

		Class<?> PARTITION_REF_TYPE =  Expression.class;

		boolean PARTITION_REF_MULTIPLE = true;

		/**
		 * ORDER_BY Reference
		 */
		String ORDER_BY_REF_NAME = Namespace.PREFIX + COLON + "orderBy";

		Class<?> ORDER_BY_REF_TYPE =  OrderBy.class;

		boolean ORDER_BY_REF_MULTIPLE = false;

	}

	/**
	 * tsql:xMLAttributes
	 */
	public interface XMLAttributes extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "xMLAttributes";

		boolean IS_ABSTRACT = false;

		/**
		 * ARGS Reference
		 */
		String ARGS_REF_NAME = Namespace.PREFIX + COLON + "args";

		Class<?> ARGS_REF_TYPE =  DerivedColumn.class;

		boolean ARGS_REF_MULTIPLE = true;

	}

	/**
	 * tsql:xMLElement
	 */
	public interface XMLElement extends Expression {

		String ID = Namespace.PREFIX + COLON + "xMLElement";

		boolean IS_ABSTRACT = false;

		/**
		 * ATTRIBUTES Reference
		 */
		String ATTRIBUTES_REF_NAME = Namespace.PREFIX + COLON + "attributes";

		Class<?> ATTRIBUTES_REF_TYPE =  XMLAttributes.class;

		boolean ATTRIBUTES_REF_MULTIPLE = false;

		/**
		 * NAMESPACES Reference
		 */
		String NAMESPACES_REF_NAME = Namespace.PREFIX + COLON + "namespaces";

		Class<?> NAMESPACES_REF_TYPE =  XMLNamespaces.class;

		boolean NAMESPACES_REF_MULTIPLE = false;

		/**
		 * CONTENT Reference
		 */
		String CONTENT_REF_NAME = Namespace.PREFIX + COLON + "content";

		Class<?> CONTENT_REF_TYPE =  Expression.class;

		boolean CONTENT_REF_MULTIPLE = true;

	}

	/**
	 * tsql:xMLForest
	 */
	public interface XMLForest extends Expression {

		String ID = Namespace.PREFIX + COLON + "xMLForest";

		boolean IS_ABSTRACT = false;

		/**
		 * ARGUMENTS Reference
		 */
		String ARGUMENTS_REF_NAME = Namespace.PREFIX + COLON + "arguments";

		Class<?> ARGUMENTS_REF_TYPE =  DerivedColumn.class;

		boolean ARGUMENTS_REF_MULTIPLE = true;

		/**
		 * NAMESPACES Reference
		 */
		String NAMESPACES_REF_NAME = Namespace.PREFIX + COLON + "namespaces";

		Class<?> NAMESPACES_REF_TYPE =  XMLNamespaces.class;

		boolean NAMESPACES_REF_MULTIPLE = false;

	}

	/**
	 * tsql:xMLNamespaces
	 */
	public interface XMLNamespaces extends LanguageObject {

		String ID = Namespace.PREFIX + COLON + "xMLNamespaces";

		boolean IS_ABSTRACT = false;

		/**
		 * NAMESPACES Reference
		 */
		String NAMESPACES_REF_NAME = Namespace.PREFIX + COLON + "namespaces";

		Class<?> NAMESPACES_REF_TYPE =  NamespaceItem.class;

		boolean NAMESPACES_REF_MULTIPLE = true;

	}

	/**
	 * tsql:xMLParse
	 */
	public interface XMLParse extends Expression {

		String ID = Namespace.PREFIX + COLON + "xMLParse";

		boolean IS_ABSTRACT = false;

		/**
		 * WELL_FORMED Property
		 */
		String WELL_FORMED_PROP_NAME = Namespace.PREFIX + COLON + "wellFormed";

		Class<?> WELL_FORMED_PROP_TYPE =  Boolean.class;

		boolean WELL_FORMED_PROP_MULTIPLE = false;

		/**
		 * DOCUMENT Property
		 */
		String DOCUMENT_PROP_NAME = Namespace.PREFIX + COLON + "document";

		Class<?> DOCUMENT_PROP_TYPE =  Boolean.class;

		boolean DOCUMENT_PROP_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}

	/**
	 * tsql:xMLQuery
	 */
	public interface XMLQuery extends Expression {

		String ID = Namespace.PREFIX + COLON + "xMLQuery";

		boolean IS_ABSTRACT = false;

		/**
		 * EMPTY_ON_EMPTY Property
		 */
		String EMPTY_ON_EMPTY_PROP_NAME = Namespace.PREFIX + COLON + "emptyOnEmpty";

		Class<?> EMPTY_ON_EMPTY_PROP_TYPE =  Boolean.class;

		boolean EMPTY_ON_EMPTY_PROP_MULTIPLE = false;

		/**
		 * XQUERY Property
		 */
		String XQUERY_PROP_NAME = Namespace.PREFIX + COLON + "xquery";

		Class<?> XQUERY_PROP_TYPE =  String.class;

		boolean XQUERY_PROP_MULTIPLE = false;

		/**
		 * PASSING Reference
		 */
		String PASSING_REF_NAME = Namespace.PREFIX + COLON + "passing";

		Class<?> PASSING_REF_TYPE =  DerivedColumn.class;

		boolean PASSING_REF_MULTIPLE = true;

		/**
		 * NAMESPACES Reference
		 */
		String NAMESPACES_REF_NAME = Namespace.PREFIX + COLON + "namespaces";

		Class<?> NAMESPACES_REF_TYPE =  XMLNamespaces.class;

		boolean NAMESPACES_REF_MULTIPLE = false;

	}

	/**
	 * tsql:xMLSerialize
	 */
	public interface XMLSerialize extends Expression {

		String ID = Namespace.PREFIX + COLON + "xMLSerialize";

		boolean IS_ABSTRACT = false;

		/**
		 * TYPE_STRING Property
		 */
		String TYPE_STRING_PROP_NAME = Namespace.PREFIX + COLON + "typeString";

		Class<?> TYPE_STRING_PROP_TYPE =  String.class;

		boolean TYPE_STRING_PROP_MULTIPLE = false;

		/**
		 * VERSION Property
		 */
		String VERSION_PROP_NAME = Namespace.PREFIX + COLON + "version";

		Class<?> VERSION_PROP_TYPE =  String.class;

		boolean VERSION_PROP_MULTIPLE = false;

		/**
		 * DECLARATION Property
		 */
		String DECLARATION_PROP_NAME = Namespace.PREFIX + COLON + "declaration";

		Class<?> DECLARATION_PROP_TYPE =  Boolean.class;

		boolean DECLARATION_PROP_MULTIPLE = false;

		/**
		 * DOCUMENT Property
		 */
		String DOCUMENT_PROP_NAME = Namespace.PREFIX + COLON + "document";

		Class<?> DOCUMENT_PROP_TYPE =  Boolean.class;

		boolean DOCUMENT_PROP_MULTIPLE = false;

		/**
		 * ENCODING Property
		 */
		String ENCODING_PROP_NAME = Namespace.PREFIX + COLON + "encoding";

		Class<?> ENCODING_PROP_TYPE =  String.class;

		boolean ENCODING_PROP_MULTIPLE = false;

		/**
		 * EXPRESSION Reference
		 */
		String EXPRESSION_REF_NAME = Namespace.PREFIX + COLON + "expression";

		Class<?> EXPRESSION_REF_TYPE =  Expression.class;

		boolean EXPRESSION_REF_MULTIPLE = false;

	}


	private static Map<String, Class<?>> astIndex = new HashMap<String, Class<?>>();

	static {
		astIndex.put(LanguageObject.class.getSimpleName(), LanguageObject.class);
		astIndex.put(Expression.class.getSimpleName(), Expression.class);
		astIndex.put(PredicateCriteria.class.getSimpleName(), PredicateCriteria.class);
		astIndex.put(SubqueryContainer.class.getSimpleName(), SubqueryContainer.class);
		astIndex.put(Labeled.class.getSimpleName(), Labeled.class);
		astIndex.put(TargetedCommand.class.getSimpleName(), TargetedCommand.class);
		astIndex.put(ExpressionStatement.class.getSimpleName(), ExpressionStatement.class);
		astIndex.put(Criteria.class.getSimpleName(), Criteria.class);
		astIndex.put(AbstractCompareCriteria.class.getSimpleName(), AbstractCompareCriteria.class);
		astIndex.put(CompareCriteria.class.getSimpleName(), CompareCriteria.class);
		astIndex.put(SubqueryCompareCriteria.class.getSimpleName(), SubqueryCompareCriteria.class);
		astIndex.put(AbstractSetCriteria.class.getSimpleName(), AbstractSetCriteria.class);
		astIndex.put(SetCriteria.class.getSimpleName(), SetCriteria.class);
		astIndex.put(SubquerySetCriteria.class.getSimpleName(), SubquerySetCriteria.class);
		astIndex.put(BetweenCriteria.class.getSimpleName(), BetweenCriteria.class);
		astIndex.put(CompoundCriteria.class.getSimpleName(), CompoundCriteria.class);
		astIndex.put(ExistsCriteria.class.getSimpleName(), ExistsCriteria.class);
		astIndex.put(ExpressionCriteria.class.getSimpleName(), ExpressionCriteria.class);
		astIndex.put(IsNullCriteria.class.getSimpleName(), IsNullCriteria.class);
		astIndex.put(MatchCriteria.class.getSimpleName(), MatchCriteria.class);
		astIndex.put(NotCriteria.class.getSimpleName(), NotCriteria.class);
		astIndex.put(Command.class.getSimpleName(), Command.class);
		astIndex.put(Alter.class.getSimpleName(), Alter.class);
		astIndex.put(AlterProcedure.class.getSimpleName(), AlterProcedure.class);
		astIndex.put(AlterTrigger.class.getSimpleName(), AlterTrigger.class);
		astIndex.put(AlterView.class.getSimpleName(), AlterView.class);
		astIndex.put(ProcedureContainer.class.getSimpleName(), ProcedureContainer.class);
		astIndex.put(Delete.class.getSimpleName(), Delete.class);
		astIndex.put(Insert.class.getSimpleName(), Insert.class);
		astIndex.put(StoredProcedure.class.getSimpleName(), StoredProcedure.class);
		astIndex.put(Update.class.getSimpleName(), Update.class);
		astIndex.put(DynamicCommand.class.getSimpleName(), DynamicCommand.class);
		astIndex.put(QueryCommand.class.getSimpleName(), QueryCommand.class);
		astIndex.put(Query.class.getSimpleName(), Query.class);
		astIndex.put(SetQuery.class.getSimpleName(), SetQuery.class);
		astIndex.put(CreateProcedureCommand.class.getSimpleName(), CreateProcedureCommand.class);
		astIndex.put(TriggerAction.class.getSimpleName(), TriggerAction.class);
		astIndex.put(FromClause.class.getSimpleName(), FromClause.class);
		astIndex.put(TableFunctionReference.class.getSimpleName(), TableFunctionReference.class);
		astIndex.put(ArrayTable.class.getSimpleName(), ArrayTable.class);
		astIndex.put(ObjectTable.class.getSimpleName(), ObjectTable.class);
		astIndex.put(TextTable.class.getSimpleName(), TextTable.class);
		astIndex.put(XMLTable.class.getSimpleName(), XMLTable.class);
		astIndex.put(JoinPredicate.class.getSimpleName(), JoinPredicate.class);
		astIndex.put(SubqueryFromClause.class.getSimpleName(), SubqueryFromClause.class);
		astIndex.put(UnaryFromClause.class.getSimpleName(), UnaryFromClause.class);
		astIndex.put(From.class.getSimpleName(), From.class);
		astIndex.put(GroupBy.class.getSimpleName(), GroupBy.class);
		astIndex.put(Into.class.getSimpleName(), Into.class);
		astIndex.put(JoinType.class.getSimpleName(), JoinType.class);
		astIndex.put(Limit.class.getSimpleName(), Limit.class);
		astIndex.put(NamespaceItem.class.getSimpleName(), NamespaceItem.class);
		astIndex.put(ProjectedColumn.class.getSimpleName(), ProjectedColumn.class);
		astIndex.put(ObjectColumn.class.getSimpleName(), ObjectColumn.class);
		astIndex.put(TextColumn.class.getSimpleName(), TextColumn.class);
		astIndex.put(XMLColumn.class.getSimpleName(), XMLColumn.class);
		astIndex.put(Option.class.getSimpleName(), Option.class);
		astIndex.put(OrderBy.class.getSimpleName(), OrderBy.class);
		astIndex.put(OrderByItem.class.getSimpleName(), OrderByItem.class);
		astIndex.put(SPParameter.class.getSimpleName(), SPParameter.class);
		astIndex.put(Select.class.getSimpleName(), Select.class);
		astIndex.put(SetClause.class.getSimpleName(), SetClause.class);
		astIndex.put(SetClauseList.class.getSimpleName(), SetClauseList.class);
		astIndex.put(SourceHint.class.getSimpleName(), SourceHint.class);
		astIndex.put(SpecificHint.class.getSimpleName(), SpecificHint.class);
		astIndex.put(SubqueryHint.class.getSimpleName(), SubqueryHint.class);
		astIndex.put(WithQueryCommand.class.getSimpleName(), WithQueryCommand.class);
		astIndex.put(Statement.class.getSimpleName(), Statement.class);
		astIndex.put(AssignmentStatement.class.getSimpleName(), AssignmentStatement.class);
		astIndex.put(DeclareStatement.class.getSimpleName(), DeclareStatement.class);
		astIndex.put(ReturnStatement.class.getSimpleName(), ReturnStatement.class);
		astIndex.put(Block.class.getSimpleName(), Block.class);
		astIndex.put(BranchingStatement.class.getSimpleName(), BranchingStatement.class);
		astIndex.put(CommandStatement.class.getSimpleName(), CommandStatement.class);
		astIndex.put(IfStatement.class.getSimpleName(), IfStatement.class);
		astIndex.put(LoopStatement.class.getSimpleName(), LoopStatement.class);
		astIndex.put(RaiseStatement.class.getSimpleName(), RaiseStatement.class);
		astIndex.put(WhileStatement.class.getSimpleName(), WhileStatement.class);
		astIndex.put(ExceptionExpression.class.getSimpleName(), ExceptionExpression.class);
		astIndex.put(Function.class.getSimpleName(), Function.class);
		astIndex.put(AggregateSymbol.class.getSimpleName(), AggregateSymbol.class);
		astIndex.put(Symbol.class.getSimpleName(), Symbol.class);
		astIndex.put(AliasSymbol.class.getSimpleName(), AliasSymbol.class);
		astIndex.put(ElementSymbol.class.getSimpleName(), ElementSymbol.class);
		astIndex.put(ExpressionSymbol.class.getSimpleName(), ExpressionSymbol.class);
		astIndex.put(GroupSymbol.class.getSimpleName(), GroupSymbol.class);
		astIndex.put(Array.class.getSimpleName(), Array.class);
		astIndex.put(CaseExpression.class.getSimpleName(), CaseExpression.class);
		astIndex.put(Constant.class.getSimpleName(), Constant.class);
		astIndex.put(DerivedColumn.class.getSimpleName(), DerivedColumn.class);
		astIndex.put(JSONObject.class.getSimpleName(), JSONObject.class);
		astIndex.put(MultipleElementSymbol.class.getSimpleName(), MultipleElementSymbol.class);
		astIndex.put(QueryString.class.getSimpleName(), QueryString.class);
		astIndex.put(Reference.class.getSimpleName(), Reference.class);
		astIndex.put(ScalarSubquery.class.getSimpleName(), ScalarSubquery.class);
		astIndex.put(SearchedCaseExpression.class.getSimpleName(), SearchedCaseExpression.class);
		astIndex.put(TextLine.class.getSimpleName(), TextLine.class);
		astIndex.put(WindowFunction.class.getSimpleName(), WindowFunction.class);
		astIndex.put(WindowSpecification.class.getSimpleName(), WindowSpecification.class);
		astIndex.put(XMLAttributes.class.getSimpleName(), XMLAttributes.class);
		astIndex.put(XMLElement.class.getSimpleName(), XMLElement.class);
		astIndex.put(XMLForest.class.getSimpleName(), XMLForest.class);
		astIndex.put(XMLNamespaces.class.getSimpleName(), XMLNamespaces.class);
		astIndex.put(XMLParse.class.getSimpleName(), XMLParse.class);
		astIndex.put(XMLQuery.class.getSimpleName(), XMLQuery.class);
		astIndex.put(XMLSerialize.class.getSimpleName(), XMLSerialize.class);
	}

	public static String getTypeId(Class<? extends ASTNode> astNodeClass) {
		try {
			Class<?> astClass = astIndex.get(astNodeClass.getSimpleName());
			Field idField = astClass.getField("ID");
			Object idValue = idField.get(null);
			return idValue.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}