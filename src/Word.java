// Copyright(c) 2016 Hung Ta
//

class Word implements Comparable
{
    private String word = "";// the word per BinaryTreeNode


    //private LinenumList lines = new LinenumList();  // lines contains Integer's which implements Comparable

    public int freq = 1;      // for testing purposes

    public Word()
    {
    }
    public Word(String s, int line)
    {
        word = s;
    }

    public boolean equals(Object el)
    {
        return word.equals(((Word)el).word);
    }

    public int compareTo(Object el)
    {
        return word.compareTo(((Word)el).word);
    }

}
