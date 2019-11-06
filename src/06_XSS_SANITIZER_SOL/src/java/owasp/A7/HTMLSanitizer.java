package owasp.A7;


import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class HTMLSanitizer {

    public String sanitizaComentario(String comentario) {
        PolicyFactory policy = new HtmlPolicyBuilder()
                .allowElements("strong", "em")
                .allowAttributes("id").onElements("strong")
                .toFactory();
        return policy.sanitize(comentario);
    }
}
