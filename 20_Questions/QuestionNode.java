public class QuestionNode {
    public String object;
    public QuestionNode yes;
    public QuestionNode no;

    public QuestionNode(String object) {
        this.object = object;
        yes = null;
        no = null;
    }
}