# zxing
Haxe binding for the ZXing library

## Usage
### Android setup
```
lime rebuild zxing android
```

### iPhone setup
coming soon

### Haxe code

```haxe
var zxing = new Zxing();
zxing.addEventListener(ScanEvent.SUCCESS, function(e) trace("success", e.contents, e.formatName));
zxing.addEventListener(ScanEvent.CANCELLED, function(e) trace("cancelled"));
zxing.initiateScan();
```
