package Tank;

public enum TypeItem 
{
    ROCK(5), BRICK(1), TREE(4), WATER(2), ;
    private int value;

    TypeItem(int value) 
    {
        this.value = value;
    }
    public static TypeItem convertIntToTypeItem(int value)
    {
        switch (value)
        {
            case 5:
                return ROCK;
            case 4: 
                return TREE;
            case 2: 
                return WATER;
            case 1: 
                return BRICK;
            default:
                return null;
        }       
    }
    public int getValue() 
    {
        return value;
    }

    public void setValue(int value) 
    {
        this.value = value;
    }
    
}
