public enum GallowsForm {
  ZERO("""
        ________
        |/     !
        |
        |
        |
        |
        |
        |
      --|---------
      """),

  ONE("""
        ________
        |/     !
        |     (_)
        |
        |
        |
        |
        |
        |
      --|---------
      """),

  TWO("""
        ________
        |/     !
        |     (_)
        |      |
        |      |
        |      |
        |
        |
        |
      --|---------
      """),

  THREE("""
        ________
        |/     !
        |     (_)
        |    --|
        |   /  |
        |      |
        |
        |
        |
      --|---------
      """),

  FOUR("""
        ________
        |/     !
        |     (_)
        |    --|--
        |   /  |  |
        |      |
        |
        |
        |
      --|---------
      """),

  FIVE("""
        ________
        |/     !
        |     (_)
        |    --|--
        |   /  |  |
        |      |
        |     /
        |    /
        |
      --|---------
      """),

  SIX("""
        ________
        |/     !
        |     (_)
        |    --|--
        |   /  |  |
        |      |
        |     / |
        |    /  |
        |
      --|---------
      """);

  private final String drawing;

  public String getDrawing() {
    return drawing;
  }

  GallowsForm(String drawing) {
    this.drawing = drawing;
  }
}
