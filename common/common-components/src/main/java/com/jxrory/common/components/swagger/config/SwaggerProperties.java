package com.jxrory.common.components.swagger.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rory
 * @date 2022/04/02
 */
@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    /**
     * 是否开启 swagger
     */
    private Boolean enabled;

    /**
     * swagger 解析的包路径
     **/
    private String basePackage = "";

    /**
     * swagger 解析的 url 规则
     **/
    private List<String> basePath = new ArrayList<>();

    /**
     * 在 basePath 基础上排除的 url 规则
     **/
    private List<String> excludePath = new ArrayList<>();

    /**
     * 标题
     **/
    private String title = "Jxrory Cloud Docs";

    /**
     * 分组
     */
    private String group = "Jxrory Cloud Docs";

    /**
     * 描述
     **/
    private String description = "";

    /**
     * 版本
     **/
    private String version = "";

    /**
     * 协议
     **/
    private String license = "";

    /**
     * 许可证 URL
     **/
    private String licenseUrl = "";

    /**
     * 服务条款 URL
     **/
    private String termsOfServiceUrl = "";

    /**
     * host信息
     **/
    private String host = "";

    /**
     * 联系人信息
     */
    private Contact contact = new Contact();

    /**
     * 全局统一鉴权配置
     **/
    private Authorization authorization = new Authorization();

    /**
     * 统一头部信息
     */
    private List<HeaderInfo> headers = new ArrayList<HeaderInfo>();

    @Data
    @NoArgsConstructor
    public static class Contact {

        /**
         * 联系人
         **/
        private String name = "";

        /**
         * 联系人url
         **/
        private String url = "";

        /**
         * 联系人email
         **/
        private String email = "";

    }

    @Data
    @NoArgsConstructor
    public static class Authorization {

        /**
         * 鉴权策略ID，需要和SecurityReferences ID保持一致
         */
        private String name = "";

        /**
         * 需要开启鉴权URL的正则
         */
        private String authRegex = "^.*$";

        /**
         * 鉴权作用域列表
         */
        private List<AuthorizationScope> authorizationScopeList = new ArrayList<>();

        private List<String> tokenUrlList = new ArrayList<>();
    }

    @Data
    @NoArgsConstructor
    public static class AuthorizationScope {

        /**
         * 作用域名称
         */
        private String scope = "";

        /**
         * 作用域描述
         */
        private String description = "";

    }

    @Data
    @NoArgsConstructor
    public static class HeaderInfo {

        /**
         * 头部key
         */
        private String key = "";

        /**
         * 是否request
         */
        private Boolean request = false;

        /**
         * 头部默认值
         */
        private String value = "";

        /**
         * 描述
         */
        private String description = "";
    }
}
