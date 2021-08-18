import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(ScreenshotPlugin)
public class ScreenshotPlugin: CAPPlugin {
//    private let implementation = Screenshot()

    @objc func echo(_ call: CAPPluginCall) {
                let implementation = Screenshot(vController: (bridge?.viewController)!)
                let value = call.getString("value") ?? ""
                call.resolve([
                    "value": "data:image/jpeg;base64," + implementation.echo(value)
                ])
    }
}
