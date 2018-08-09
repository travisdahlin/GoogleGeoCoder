String detail = "";
try
{
	String base    = 'https://maps.googleapis.com/maps/api/geocode/xml?address='
    // Ender address [street, city, state]
	List location  = ['1600 Pennsylvania AVenue', 'Washington', 'DC']
	String encoded = location.collect {URLEncoder.encode(it, 'UTF-8')}.join(/,/)
	def root       = new XmlSlurper().parse("$base$encoded")
	def coord      = root.result[0].geometry.location
	
    println "$base$encoded"

	detail += "latitude: ${coord.lat}\n"
	detail += "longitude: ${coord.lng}\n"
	detail += "(${coord.lat}, ${coord.lng})"
}
catch (Exception e)
{
    detail += "Exception Thrown : $e\n"
    detail += "${e.class}: ${e.message}"
    e.getStackTrace().each
    {trace ->
        detail += "\n\t $trace"
    }
    
    def nested = e.getCause()
    detail += nested ? "\ncaused by ${nested.getClass()}: ${nested.getMessage()}" : ""
    nested.each
    {trace ->
    	detail += "\n\t ${trace.getCause()}"
    }
}

println detail

