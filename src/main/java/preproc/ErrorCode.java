package preproc;

public enum ErrorCode {
    E_FILE_NOT_FOUND,
      E_UNTERMINATED_COMMENT,
      E_UNTERMINATED_STRING_CONSTANT,
      E_UNTERMINATED_CHAR_CONSTANT,
      E_HASH_HASH_AT_BEGIN_REPL,
      E_HASH_HASH_AT_END_REPL,
      E_NO_FORMAT_PARAMETER_AFTER_SHARP,

      W_DEFINED_IN_REPLACEMENT_LIST,
      W_PP_DIRECTIVE_IN_ARGUMENT_LIST,
}