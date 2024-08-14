import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // For demonstration, returning a static user. 
        // Replace with logic to get the currently authenticated user.
        return Optional.of("admin");
    }
}
