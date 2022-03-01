package ast.tree;

import ast.parse.Parse;
import ast.parse.ParseStatement;
import jscan.symtab.Keywords;
import jscan.tokenize.Token;

public class BreakContinue {
  private final Parse parser;
  private final ParseStatement parseStatement;

  public BreakContinue(Parse parser, ParseStatement parseStatement) {
    this.parser = parser;
    this.parseStatement = parseStatement;
  }

  private boolean canBreak() {
    boolean hasSWitch = !parseStatement.getSwitches().isEmpty();
    boolean hasLoop = !parseStatement.getLoops().isEmpty();
    return hasSWitch || hasLoop;
  }

  private boolean canContinue() {
    return !parseStatement.getLoops().isEmpty();
  }

  private void checkBreak() {
    if (!canBreak()) {
      parser.perror("stray `break`");
    }
  }

  private void checkContinue() {
    if (!canContinue()) {
      parser.perror("stray `continue`");
    }
  }

  public Statement breakStatement() {
    checkBreak();

    Token from = parser.checkedMove(Keywords.break_ident);
    parser.semicolon();
    return new Statement(from, StatementBase.SBREAK);
  }

  public Statement continueStatement() {
    checkContinue();

    Token from = parser.checkedMove(Keywords.continue_ident);
    parser.semicolon();
    return new Statement(from, StatementBase.SCONTINUE);
  }

}