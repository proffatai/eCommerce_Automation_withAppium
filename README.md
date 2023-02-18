## Handling Toast messages in android
Toast messages in android are simple those messages that appears for a short period of time when a certain button is clicked and quickly disappears after
a short period of time.

It has been made compulsory that in order for developers to create a toast message, he must use the tagname `android.widget.Toast`
So we can handle / access the toast via xpath using just its tag name as, //android.widget.Toast. In event where there are multiple toast messages, 
we can apply indexing to locate the specific toast message of our choice e.g By.xpath("(//android.widget.Toast)[1]")


Similarly, android has made it mandatory that the toast tag must have the attribute `name` which contains the message that will be displayed so we can 
get the text during automation using `String errorMessage=driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name")`
or simply `String errorMessage=driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getText()`
Now we can use the text gotten from the toast to perform assertion