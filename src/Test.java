class Test
{
    public static void main(String[] args)
    {
        String workingdir = System.getProperty("user.dir");
        String filepath = workingdir.substring(0,workingdir.length()-4);
        System.out.println(filepath);
    }
}