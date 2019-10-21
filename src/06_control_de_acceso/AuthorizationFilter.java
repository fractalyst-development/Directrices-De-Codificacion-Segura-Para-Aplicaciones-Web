public final class AuthorizationFilter implements Filter {
    /**
     * This is the Policy Enforcement Point (PEP). This is the point in code where
     * the authorization decision is made
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        // get the user (Subject), Object being acted upon, Action requested, etc
        // Call the function that performs the access control check
        if (canDoAction(user, object, action)) {
            // forward to the requested page
        }
        // return an "Access Denied" screen
    }

    /**
    * This is the Policy Decision Point (PDP). It is the function
    * that actually evaluates the Subject, Object, Action, etc
    * (collectively Policy Information Points, or PIPs) to
    * determine whether access should be granted.
    */
    public boolean canDoAction(User user, Object object, Action action) {
        // Use PIPs to make your decision!
        //Object Attributes
        if (object.isTopSecret()) {
            //Subject Attributes
            if (user.hasTopSecretClearance()) {
                return true
            }
        } else {
            //evaluate other conditions, based on action, etc
        }
        //if no positive conditions are met, fail secure
        return false;
    }
}