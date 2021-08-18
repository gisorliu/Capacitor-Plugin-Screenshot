import Foundation
import UIKit

@objc public class Screenshot: NSObject {
    let viewContronller:UIViewController
        
        public init(vController:UIViewController) {
            self.viewContronller = vController
        }
        
        @objc public func echo(_ value: String) -> String {
            //截屏
            let screenRect = UIScreen.main.bounds
//            UIGraphicsBeginImageContext(screenRect.size)
            UIGraphicsBeginImageContextWithOptions(screenRect.size,true,UIScreen.main.scale)
            let ctx = UIGraphicsGetCurrentContext()!
            self.viewContronller.view.layer.render(in: ctx)
            let image:UIImage = UIGraphicsGetImageFromCurrentImageContext()!
            UIGraphicsEndImageContext()
            
            let data:Data = image.jpegData(compressionQuality: 1)!
            return data.base64EncodedString(options: .endLineWithLineFeed)
        }
}
