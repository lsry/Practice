public class Permission{
    /**
     * 权限表示
     */
    public static final int INSERT = 1 << 0;
    public static final int DELETE = 1 << 1;
    public static final int SELECT = 1 << 2;
    public static final int UPDATE = 1 << 3;

    /**
     * 目前权限状态
     */
    private int permission;

    /**
     * 设置权限
     */
    public void setPermission(int permission){
        this.permission = permission;
    }

    /**
     * 添加一项或多项权限
     */
    public void addPermission(int permission){
        this.permission |= permission;
    }

    /**
     * 删除一项或多项权限
     */
    public void deletePermission(int permission){
        this.permission &= ~permission;
    }

    /**
     * 是否拥有一项或多项权限
     */
    public boolean contain(int permission){
        return (this.permission & permission) == permission;
    }

    /**
     * 是否禁用了某些权限
     */
    public boolean noPermission(int permission) {
        return (this.permission & permission) == 0;
    }

    /**
     * 是否仅仅拥有某些权限
     */
    public boolean isOnlyAllow(int permission) {
        return this.permission == permission;
    }
}