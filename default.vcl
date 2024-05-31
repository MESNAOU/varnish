#
# This is an example VCL file for Varnish.
#
# It does not do anything by default, delegating control to the
# builtin VCL. The builtin VCL is called when there is no explicit
# return statement.
#
# See the VCL chapters in the Users Guide for a comprehensive documentation
# at https://www.varnish-cache.org/docs/.

# Marker to tell the VCL compiler that this VCL has been written with the
# 4.0 or 4.1 syntax.
vcl 4.1;

# Default backend definition. Set this to point to your content server.
backend default {
    .host = "referentiel-service";
    .port = "9001";
}

sub vcl_recv {
    # Happens before we check if we have this in cache already.
    #
    # Typically you clean up the request here, removing cookies you don't need,
    # rewriting the request, etc.
    
    #if (req.url ~ "^/Units1" || req.url ~ "^/Units2" || req.url ~ "^/Units3") {
    #    set req.backend_hint = default;
    #    return (hash);
    #}
    if (req.method == "GET") {
        set req.backend_hint = default;
        return (hash);
    } else if (req.method == "POST" || req.method == "PUT" || req.method == "DELETE") {
        return (pass);
    }
}

sub vcl_backend_response {
    # Happens after we have read the response headers from the backend.
    #
    # Here you clean the response headers, removing silly Set-Cookie headers
    # and other mistakes your backend does.
    #if (bereq.url == "/Units1" || bereq.url == "/Units2" bereq.url == "/Units3") {
    set beresp.do_esi = true;
    if (!beresp.ttl) {
        set beresp.ttl = 1h;
    }
}

sub vcl_deliver {
    # Happens when we have all the pieces we need, and are about to send the
    # response to the client.
    #
    # You can do accounting or modifying the final object here.
}
