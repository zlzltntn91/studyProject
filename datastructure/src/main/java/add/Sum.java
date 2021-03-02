package add;

public class Sum {

  int result;

  public int useWhile (int i) {
    if (i == 0) return result;
    result += i--;
    return useWhile(i);
  }

  public int useWhileLocalVariable (int i) {
    if (i == 1) return 1;
    return i + useWhileLocalVariable(--i);
  }

}
